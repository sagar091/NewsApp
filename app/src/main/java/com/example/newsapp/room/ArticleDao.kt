package com.example.newsapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.newsapp.model.Article
import java.util.concurrent.Flow

@Dao
interface ArticleDao {

    @Insert
    suspend fun insert(article: Article)

    @Query("SELECT * FROM article")
    fun getArticles(): List<Article>
}