package com.example.appwithkoin.feature.homescreen.data.repository
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductResponseItem


interface ProductRepository{
    suspend fun getHomeProduct():List<ProductResponseItem>
}