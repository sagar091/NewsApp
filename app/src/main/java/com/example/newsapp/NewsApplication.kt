package com.example.newsapp

import android.app.Application
import com.example.newsapp.di.appModule
import com.example.newsapp.di.detailModule
import com.example.newsapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@NewsApplication)

            modules(
                appModule,
                mainModule,
                detailModule
            )
        }
    }
}