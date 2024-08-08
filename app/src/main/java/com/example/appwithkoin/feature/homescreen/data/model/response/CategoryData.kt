package com.example.appwithkoin.feature.homescreen.data.model.response

data class CategoryData(
    val category: Category,
    val colors: List<String>,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val sizes: List<String>,
    val thred: Thred,
    val title: String
)