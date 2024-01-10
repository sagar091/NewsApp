package com.example.newsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.adapter.NewsPagingAdapter
import com.example.newsapp.data.NetworkResult
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.utility.PrefUtils
import com.example.newsapp.utility.Utility
import com.example.newsapp.utility.extensions.getValue
import com.example.newsapp.utility.loader.ProgressUtils
import com.example.newsapp.utility.onDone
import com.example.newsapp.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsAdapter
    private lateinit var pagingAdapter: NewsPagingAdapter

    final val a=10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observer()
        listener()
    }

    private fun listener() {
        binding.edtSearch.onDone {
            if (!binding.edtSearch.text.toString().trim().isNullOrEmpty()) {
                viewModel.getArticles(binding.edtSearch.text.toString().trim())
            }
        }
    }

    private fun init() {
        adapter = NewsAdapter(this, arrayListOf())
        // binding.rvNews.adapter = adapter

        /* if (PrefUtils.contains(this, PrefUtils.SEARCH)) {
             binding.edtSearch.setText(PrefUtils.getStringValue(this, PrefUtils.SEARCH))
             viewModel.getArticles(binding.edtSearch.getValue())
         }*/

        pagingAdapter = NewsPagingAdapter(this)
        binding.rvNews.adapter = pagingAdapter

        pagingAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading) {
                ProgressUtils.showProgress(this)
            } else {
                ProgressUtils.hideProgress()
                val error = when {
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                error?.let {
                    if (pagingAdapter.itemCount == 0) {
                        Toast.makeText(this, it.error.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        if (PrefUtils.contains(this, PrefUtils.SEARCH)) {
            binding.edtSearch.setText(PrefUtils.getStringValue(this, PrefUtils.SEARCH))

            lifecycleScope.launch {
                viewModel.getPagingData(binding.edtSearch.getValue()).collect {
                    pagingAdapter.submitData(lifecycle, it)
                }
            }
        }
    }

    private fun observer() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.articleState.collect { result ->
                    when (result) {
                        is NetworkResult.Success -> {
                            ProgressUtils.hideProgress()
                            if (!result.data.articles.isNullOrEmpty()) {
                                Log.e("Size_Total", result.data.totalResults.toString())
                                Log.e("Size_Load", result.data.articles.size.toString())
                                PrefUtils.setStringValue(
                                    this@MainActivity,
                                    PrefUtils.SEARCH,
                                    binding.edtSearch.getValue()
                                )
                                adapter.setData(result.data.articles)
                            } else {
                                adapter.setData(arrayListOf())
                                binding.emptyView.root.visibility = View.VISIBLE
                                binding.emptyView.txtEmpty.text = getString(R.string.no_data)
                            }
                        }

                        is NetworkResult.Error -> {
                            binding.emptyView.root.visibility = View.GONE
                            ProgressUtils.hideProgress()
                            Utility.showToast(this@MainActivity, result.message)
                        }

                        is NetworkResult.Loading -> {
                            binding.emptyView.root.visibility = View.GONE
                            if (result.isLoading) {
                                ProgressUtils.showProgress(this@MainActivity)
                            }
                        }

                        is NetworkResult.NoInternet -> {
                            adapter.setData(arrayListOf())
                            binding.emptyView.root.visibility = View.VISIBLE
                            ProgressUtils.hideProgress()
                            binding.emptyView.txtEmpty.text = getString(R.string.no_internet)
                        }
                    }
                }
            }
        }
    }
}