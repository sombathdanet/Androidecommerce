package com.example.appwithkoin.util.network

import retrofit2.HttpException

sealed class DataState<out R> {
    data class Success<out T>(val  data: T) : DataState<T>()
    data class Error<out T>(val exception: T) : DataState<Nothing>()
    data object Loading : DataState<Nothing>()
}