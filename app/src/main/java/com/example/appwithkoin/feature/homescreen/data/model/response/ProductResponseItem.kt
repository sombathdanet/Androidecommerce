package com.example.appwithkoin.feature.homescreen.data.model.response

data class ProductResponseItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)