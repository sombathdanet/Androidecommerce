package com.example.appwithkoin.di

import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepository
import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepositoryImp
import org.koin.dsl.module


val repositoryModule = module{
    single<ProductRepository> { ProductRepositoryImp(get()) }
}