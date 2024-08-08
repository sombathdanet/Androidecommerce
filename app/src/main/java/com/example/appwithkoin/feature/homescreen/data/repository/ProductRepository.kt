package com.example.appwithkoin.feature.homescreen.data.repository
import com.example.appwithkoin.feature.homescreen.data.model.response.CategoryData
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductData
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductHome
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductResponseItem


interface ProductRepository{
    suspend fun getHomeProduct():List<ProductData>
    suspend fun getCategoryProduct():List<CategoryData>
}