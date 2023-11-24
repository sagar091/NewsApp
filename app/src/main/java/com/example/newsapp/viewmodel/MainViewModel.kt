package com.example.newsapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.DataRepository
import com.example.newsapp.data.NetworkResult
import com.example.newsapp.model.response.ArticleListResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val context: Context, private val dataRepository: DataRepository) :
    ViewModel() {

    private val _articleState: MutableStateFlow<NetworkResult<ArticleListResponse>> =
        MutableStateFlow(NetworkResult.Loading(false))
    val articleState: StateFlow<NetworkResult<ArticleListResponse>> = _articleState
    private var job: Job? = null

    fun getArticles(query: String) {
        job = viewModelScope.launch {
            dataRepository.getLeads(query)
                .collect {
                    _articleState.value = it
                }
        }
    }
}