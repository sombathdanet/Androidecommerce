package com.example.appwithkoin.feature.homescreen.data.model.response

data class Paging(
    val currnetPage: Int,
    val limit: Int,
    val total: Int,
    val totalPage: Int
)