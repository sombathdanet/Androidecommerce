package com.example.appwithkoin.feature.homescreen.data.network.model.response

data class HomeTrendingResponse (
    val status: Long,
    val message: String,
    val data: List<HomeTrendingData>
)

data class HomeTrendingData (
    val title: String,
    val  items: List<HomeTrendingItem>
)

data class HomeTrendingItem (
    val proID: Long,
    val title: String,
    val price: Long,
    val image: List<String>
)
