package com.example.appwithkoin.di
import com.example.appwithkoin.core.network.provideRetrofit
import com.example.appwithkoin.feature.authscreen.data.network.AuthNetworkDataSource
import com.example.appwithkoin.feature.homescreen.data.network.NetworkData
import org.koin.dsl.module
import retrofit2.Retrofit


val networkModule = module {
    single { provideRetrofit() }
    single { get<Retrofit>().create(NetworkData::class.java) }
    single { get<Retrofit>().create(AuthNetworkDataSource::class.java) }
}
