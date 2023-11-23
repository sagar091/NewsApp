package com.example.newsapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String?,
    val urlToImage: String,
    val url: String,
    val publishedAt: String,
    val author: String
    // val source: Source,
) : Parcelable

@Parcelize
data class Source(
    val name: String
) : Parcelable
