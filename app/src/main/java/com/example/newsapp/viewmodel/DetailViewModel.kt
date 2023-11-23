package com.example.newsapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.Article
import com.example.newsapp.room.ArticleDao
import kotlinx.coroutines.launch

class DetailViewModel(private val context: Context, private val dao: ArticleDao) :
    ViewModel() {

    fun saveArticle(article: Article) = viewModelScope.launch {
        dao.insert(article)
    }
}