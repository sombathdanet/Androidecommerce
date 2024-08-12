package com.example.appwithkoin.feature.homescreen.data.network.model.response

data class MainCategoryResponse (
    val status: Long,
    val message: String,
    val data: List<MainCategoryData>
)

data class MainCategoryData (
    val id: Long,
    val name: String,
    val image: String
)
