package com.example.newsapp.data.api

import java.io.Serializable

data class BaseResponse<T>(
    var status: String,
    var totalResults: Long,
    var message: String,
    var articles: T?
) : Serializable
