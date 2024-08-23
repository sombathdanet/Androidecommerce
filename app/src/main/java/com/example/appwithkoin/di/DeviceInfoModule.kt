package com.example.appwithkoin.di
import com.example.appwithkoin.core.device.DeviceInfoModule
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
    val deviceInfoModule = module {
        single { DeviceInfoModule(androidContext()) }
    }