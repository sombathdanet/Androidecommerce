package com.example.appwithkoin.feature.homescreen.data.model.response

data class ProductHome(
    val data: List<ProductData>,
    val message: String,
    val status: Int
)