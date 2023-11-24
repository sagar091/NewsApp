package com.example.newsapp.utility.loader

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.R


object ProgressUtils {
    private var customProgressBar: CustomProgressBar? = null

    fun showProgress(context: Context?, title: String) {
        customProgressBar = CustomProgressBar.with(title)
        customProgressBar!!.show(
            (context as AppCompatActivity).supportFragmentManager,
            CustomProgressBar.TAG
        )
    }

    fun showProgress(context: Context?) {
        customProgressBar = CustomProgressBar.with(context?.getString(R.string.label_loading))
        customProgressBar!!.show(
            (context as AppCompatActivity).supportFragmentManager,
            CustomProgressBar.TAG
        )
    }

    fun changeText(text: String) {
        if (customProgressBar != null && customProgressBar!!.isAdded && customProgressBar!!.isVisible) {
            customProgressBar!!.changeText(text)
        }
    }

    fun hideProgress() {
        try {
            if (customProgressBar != null && customProgressBar!!.isAdded && customProgressBar!!.isVisible) {
                customProgressBar?.dismiss()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun isProgressVisible(): Boolean {
        return customProgressBar != null && customProgressBar!!.isVisible
    }
}