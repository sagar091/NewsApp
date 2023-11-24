package com.example.newsapp.data.api

import com.example.newsapp.model.*
import com.example.newsapp.model.response.ArticleListResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("everything")
    suspend fun getArticles(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String
    ): Response<ArticleListResponse>

}