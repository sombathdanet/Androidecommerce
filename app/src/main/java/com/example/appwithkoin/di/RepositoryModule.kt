package com.example.appwithkoin.di

import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepository
import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepositoryImp
import org.koin.dsl.module


val repositoryModule = module{
    factory <ProductRepository> { ProductRepositoryImp(get()) }
}