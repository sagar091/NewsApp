package com.example.newsapp.ui

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.BR
import com.example.newsapp.databinding.ActivityNewsDetailsBinding
import com.example.newsapp.model.Article
import com.example.newsapp.utility.Utility
import com.example.newsapp.utility.clickWithThrottle
import com.example.newsapp.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailsActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityNewsDetailsBinding
    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentValues()
        init()
        clickListener()
    }

    private fun clickListener() {
        binding.txtReadMore.clickWithThrottle {
            article?.let { Utility.openIntentUrl(this, it.url) }
        }

        binding.fabSaveArticle.clickWithThrottle {
            article?.let {
                viewModel.saveArticle(it)
            }
        }
    }

    private fun getIntentValues() {

        article = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("news", Article::class.java)
        } else {
            intent.getParcelableExtra("news")
        }

        binding.setVariable(BR.model, article)
    }

    private fun init() {

    }
}