package com.example.newsapp.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.BR
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.Article
import com.example.newsapp.ui.NewsDetailsActivity
import com.example.newsapp.utility.Utility
import com.example.newsapp.utility.clickWithThrottle
import com.example.newsapp.utility.putParcel

internal class NewsAdapter(private val context: Context, private var data: ArrayList<Article>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    internal inner class NewsViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.setVariable(BR.model, data[position])

        holder.itemView.clickWithThrottle {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra("news", data[position])
            context.startActivity(intent)

           // Utility.openIntentUrl(context, data[position].url)
        }

        //holder.binding.txtNewsTitle.text = data[position].title
        //holder.binding.txtNewsTime.text = data[position].publishedAt
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(it: List<Article>) {
        data = arrayListOf()
        data.addAll(it)
        notifyDataSetChanged()
    }

    fun clearData() {
        data = arrayListOf()
        notifyDataSetChanged()
    }
}