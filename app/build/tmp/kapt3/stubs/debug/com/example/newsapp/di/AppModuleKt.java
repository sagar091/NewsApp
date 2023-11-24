package com.example.newsapp.di;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0012H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0014H\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0017"}, d2 = {"appModule", "Lorg/koin/core/module/Module;", "getAppModule", "()Lorg/koin/core/module/Module;", "provideApiService", "Lcom/example/newsapp/data/api/ApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideDao", "Lcom/example/newsapp/room/ArticleDao;", "db", "Lcom/example/newsapp/room/ArticleDatabase;", "provideDataRepository", "Lcom/example/newsapp/data/DataRepository;", "context", "Landroid/content/Context;", "apiService", "provideDatabase", "Landroid/app/Application;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "provideRetrofit", "okHttpClient", "app_debug"})
public final class AppModuleKt {
    @org.jetbrains.annotations.NotNull
    private static final org.koin.core.module.Module appModule = null;
    
    @org.jetbrains.annotations.NotNull
    public static final org.koin.core.module.Module getAppModule() {
        return null;
    }
    
    private static final okhttp3.OkHttpClient provideOkHttpClient(android.content.Context context) {
        return null;
    }
    
    private static final retrofit2.Retrofit provideRetrofit(okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    private static final com.example.newsapp.data.api.ApiService provideApiService(retrofit2.Retrofit retrofit) {
        return null;
    }
    
    private static final com.example.newsapp.room.ArticleDatabase provideDatabase(android.app.Application context) {
        return null;
    }
    
    private static final com.example.newsapp.room.ArticleDao provideDao(com.example.newsapp.room.ArticleDatabase db) {
        return null;
    }
    
    private static final com.example.newsapp.data.DataRepository provideDataRepository(android.content.Context context, com.example.newsapp.data.api.ApiService apiService) {
        return null;
    }
}