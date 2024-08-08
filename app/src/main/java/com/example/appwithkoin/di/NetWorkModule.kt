package com.example.appwithkoin.di
import ApiService
import com.example.appwithkoin.util.ServerRoute
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(ServerRoute.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(ApiService::class.java) }
}