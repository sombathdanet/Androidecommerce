package com.example.appwithkoin.api

import com.example.appwithkoin.util.ServerRoute
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(ServerRoute.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttpClient())
        .build()
}
internal fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}
