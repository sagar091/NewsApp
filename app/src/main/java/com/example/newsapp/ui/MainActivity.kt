package com.example.newsapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.utility.PrefUtils
import com.example.newsapp.utility.onDone
import com.example.newsapp.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsAdapter

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
        binding.rvNews.adapter = adapter

        if (PrefUtils.contains(this, PrefUtils.SEARCH)) {
            binding.edtSearch.setText(PrefUtils.getStringValue(this, PrefUtils.SEARCH))
            viewModel.getArticles(binding.edtSearch.text.toString().trim())

            /*viewModel.getNewArticles(binding.edtSearch.text.toString().trim()).observe(this) {
                if (it != null) {
                    if (it.isNotEmpty()) {
                        binding.txtLoading.visibility = View.GONE
                        adapter.setData(it)
                    } else {
                        binding.txtLoading.text = "No Data"
                        binding.txtLoading.visibility = View.VISIBLE
                        adapter.clearData()
                    }
                }
            }*/
        }
    }

    private fun observer() {
        viewModel.loading.observe(this) {
            if (it) {
                binding.txtLoading.visibility = View.VISIBLE
                binding.txtLoading.text = "Loading.."
            } else {
                binding.txtLoading.visibility = View.GONE
            }
        }

        viewModel.errorMessage.observe(this) {
            if (it.isNullOrEmpty()) {
                binding.txtLoading.visibility = View.GONE
            } else {
                binding.txtLoading.visibility = View.VISIBLE
                binding.txtLoading.text = it
                adapter.clearData()
            }
        }

        viewModel.noInternetMsg.observe(this) {
            if (it) {
                binding.txtLoading.visibility = View.VISIBLE
                binding.txtLoading.text = "No internet"
            } else {
                binding.txtLoading.visibility = View.GONE
            }
        }

        //region Way-1
        /*
        * In case of livedata, use below observable
        * */
        /*viewModel.articles.observe(this) {
            if (!it.isNullOrEmpty()) {
                binding.txtLoading.visibility = View.GONE
                adapter.setData(it)
            } else {
                binding.txtLoading.text = "No Data"
                binding.txtLoading.visibility = View.VISIBLE
                adapter.clearData()
            }
        }*/
        //endregion

        //region Way-2
        /*
        * In case of State Flow, use below flow collection
        * */
        /*lifecycleScope.launch {
            viewModel.articlesStateFlow.collectLatest {
                if (it.isNotEmpty()) {
                    binding.txtLoading.visibility = View.GONE
                    adapter.setData(it)
                } else {
                    binding.txtLoading.text = "No Data"
                    binding.txtLoading.visibility = View.VISIBLE
                    adapter.clearData()
                }
            }
        }*/
        //endregion

        //region Way-3
        /*
        * In case of Shared Flow, use below flow collection
        * */
        /*lifecycleScope.launch {
            viewModel.articlesSharedFlow.collectLatest {
                if (it.isNotEmpty()) {
                    binding.txtLoading.visibility = View.GONE
                    adapter.setData(it)
                } else {
                    binding.txtLoading.text = "No Data"
                    binding.txtLoading.visibility = View.VISIBLE
                    adapter.clearData()
                }
            }
        }*/
        //endregion

        //region Way-4
        /*
        * In case of Shared Flow, use below flow collection, an alternate way for way-3
        * */
        lifecycleScope.launch {
            viewModel.latestArticles.collectLatest {
                if (it.isNotEmpty()) {
                    binding.txtLoading.visibility = View.GONE
                    adapter.setData(it)
                } else {
                    binding.txtLoading.text = "No Data"
                    binding.txtLoading.visibility = View.VISIBLE
                    adapter.clearData()
                }
            }
        }
        //endregion

    }
}