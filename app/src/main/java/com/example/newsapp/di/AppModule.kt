package com.example.newsapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.newsapp.BuildConfig
import com.example.newsapp.api.ApiService
import com.example.newsapp.room.ArticleDao
import com.example.newsapp.room.ArticleDatabase
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
    single { provideDatabase(get()) }
    single { provideDao(get()) }
}

private fun provideOkHttpClient(context: Context) = run {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)


    /*val headerInterceptor = Interceptor { chain ->
        val auth =
            "${AppConstants.BEARER} ${PrefUtils.getStringValue(context, PrefUtils.AUTH_TOKEN)}"
        val newRequest = chain.request().newBuilder()
            .addHeader(AppConstants.AUTHORIZATION, auth)
            .addHeader(
                AppConstants.COMMUNITY_ID,
                PrefUtils.getIntValue(context, PrefUtils.COMMUNITY_ID).toString()
            )
            .addHeader(
                AppConstants.UNIQUE_TOKEN,
                PrefUtils.getStringValue(context, PrefUtils.UNIQUE_TOKEN)
            )
            .addHeader(
                AppConstants.ACCEPT_LANGUAGE,
                PrefUtils.getStringValue(
                    context,
                    PrefUtils.APP_LANGUAGE,
                    LanguageType.English.value
                )
            )
            .addHeader(AppConstants.CONTENT_TYPE, AppConstants.APPLICATION_JSON)
            .addHeader(AppConstants.ACCEPT_HEADER, AppConstants.APPLICATION_JSON)
            .build()
        chain.proceed(newRequest)
    }*/

    OkHttpClient.Builder()
        //.addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .protocols(listOf(Protocol.HTTP_1_1))
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}

private fun provideRetrofit(
    okHttpClient: OkHttpClient
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.HOST)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)


private fun provideDatabase(context: Application): ArticleDatabase =
    Room.databaseBuilder(context, ArticleDatabase::class.java, "articles")
        //.fallbackToDestructiveMigration()
        .build()

private fun provideDao(db: ArticleDatabase): ArticleDao = db.getArticleDao()