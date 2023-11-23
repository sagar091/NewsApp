package com.example.newsapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.ApiService
import com.example.newsapp.model.Article
import com.example.newsapp.utility.PrefUtils
import com.example.newsapp.utility.Utility
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.SocketTimeoutException

class MainViewModel(private val context: Context, private val apiService: ApiService) :
    ViewModel() {

    // Below are the multiple ways to send the data from view-model to view
    // way-1
    private val articles = MutableLiveData<List<Article>>()

    // way-2
    private val _articlesStateFlow = MutableStateFlow(listOf<Article>())
    val articlesStateFlow = _articlesStateFlow.asStateFlow()

    // way-3
    private val _articlesSharedFlow = MutableSharedFlow<List<Article>>()
    val articlesSharedFlow = _articlesSharedFlow.asSharedFlow()

    // way-4
    var latestArticles = MutableSharedFlow<List<Article>>()

    val loading = MutableLiveData<Boolean>()
    val noInternetMsg = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        loading.postValue(false)
        throwable.message?.let { Log.e("ERROR", it) }
        if (throwable is ConnectException || throwable is SocketTimeoutException) {
            // exception messages: Failed to connect - OR - timeout / Read timed out
            noInternetMsg.postValue(true)
        } else {
            errorMessage.postValue("Something went wrong. Please try again")
        }
    }

    fun getArticles(query: String) {
        noInternetMsg.postValue(false)
        loading.postValue(true)
        if (!Utility.isInternetAvailable(context)) {
            loading.postValue(false)
            noInternetMsg.postValue(true)
            return
        }
        job = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = apiService.getArticles(query, "e13767b2e58b4d4c97897fb29d627273")
            withContext(Dispatchers.Main) {
                loading.postValue(false)
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        response.body()?.let {
                            if (it.status == "ok") {

                                if (!it.articles.isNullOrEmpty()) {
                                    /*
                                     * Saving the query to call the api with same parameter, when user reopen the app
                                     * */
                                    PrefUtils.setStringValue(context, PrefUtils.SEARCH, query)

                                    articles.postValue(it.articles) // way-1
                                    _articlesStateFlow.emit(it.articles!!) // way-2
                                    _articlesSharedFlow.emit(it.articles!!) // way-3
                                    latestArticles.emit(it.articles!!) // way-4

                                } else {
                                    errorMessage.postValue("No Data")
                                }

                            } else {
                                errorMessage.postValue(it.message)
                            }
                        }
                    } else {
                        errorMessage.postValue(response.message())
                    }
                } else {
                    errorMessage.postValue(response.message())
                }
            }
        }
    }


    fun getNewArticles(query: String) = liveData {
        withContext(Dispatchers.IO + exceptionHandler) {
            val response = apiService.getArticles(query, "e13767b2e58b4d4c97897fb29d627273")
            emit(response.body()!!.articles)
        }
    }
}