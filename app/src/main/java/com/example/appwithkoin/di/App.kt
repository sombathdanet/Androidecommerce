package com.example.appwithkoin.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp) // Provide the application context
            modules(
                deviceInfoModule,
                appModule,
                networkModule,
                repositoryModule
            )
        }
    }
}