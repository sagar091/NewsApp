package com.example.newsapp.data

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.newsapp.R
import com.example.newsapp.data.api.ApiService
import com.example.newsapp.paging.NewsDataSource
import com.example.newsapp.utility.Utility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONObject
import java.net.ConnectException
import java.net.SocketTimeoutException

class DataRepository(private val context: Context, private val apiService: ApiService) {

    companion object {

        const val API_KEY = "e13767b2e58b4d4c97897fb29d627273"
    }

    // Get Data
    suspend fun getLeads(
        query: String,
    ) = flow {

        // check internet connectivity
        if (!Utility.isInternetAvailable(context)) {
            emit(NetworkResult.NoInternet())
            return@flow
        }

        emit(NetworkResult.Loading(true))

        val response = apiService.getArticles(query, API_KEY)

        // handle success response
        response.body()?.let { body ->
            emit(NetworkResult.Success(body))
            return@flow
        }

        // handle failure response
        response.errorBody()?.let { errorBody ->
            val jObjError = JSONObject(errorBody.string())
            emit(NetworkResult.Error(message = jObjError.getString("message").toString()))
            return@flow
        }

    }.catch { exc ->
        // handle exception
        if (exc is ConnectException || exc is SocketTimeoutException) {
            emit(NetworkResult.NoInternet())
        } else {
            emit(NetworkResult.Error(exc.message ?: context.getString(R.string.try_again)))
        }

    }.flowOn(Dispatchers.IO)

    fun getPagingData(query: String) = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 60),
        pagingSourceFactory = { NewsDataSource(apiService, query, API_KEY) }
    ).flow

}