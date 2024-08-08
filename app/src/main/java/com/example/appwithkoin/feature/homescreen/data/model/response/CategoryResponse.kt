package com.example.appwithkoin.feature.homescreen.data.model.response

data class CategoryResponse(
    val data: List<CategoryData>,
    val message: String,
    val paging: Paging,
    val status: Int
)