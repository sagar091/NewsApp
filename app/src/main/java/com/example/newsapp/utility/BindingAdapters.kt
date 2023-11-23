package com.example.newsapp.utility

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: AppCompatImageView, imageUrl: String?) {
            val options: RequestOptions =
                RequestOptions().centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
            Glide.with(view.context).load(imageUrl).apply(options).transform(
                CenterCrop(),
                RoundedCorners(24)
            ).into(view)
        }

        @JvmStatic
        @BindingAdapter("setVisibility")
        fun setVisibility(view: AppCompatTextView, content: String?) {
            if (content.isNullOrEmpty()) {
                view.visibility = View.GONE
            } else {
                view.visibility = View.VISIBLE
            }
        }

    }
}