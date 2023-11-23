package com.example.newsapp.api

import com.example.newsapp.model.*
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("everything")
    suspend fun getArticles(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String
    ): Response<BaseResponse<List<Article>>>

}