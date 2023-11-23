package com.example.newsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.model.Article

@Database(entities = [Article::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao
}