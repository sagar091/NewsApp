package com.example.newsapp.model.response

import com.example.newsapp.model.Article

data class ArticleListResponse(
    var status: String,
    var totalResults: Long,
    var message: String,
    var articles: List<Article>
)