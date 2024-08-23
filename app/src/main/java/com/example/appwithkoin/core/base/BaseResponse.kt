package com.example.appwithkoin.core.base

class BaseResponse<T> (
    val status:Int,
    val message:String,
    val data:T
)
data class ErrorResponse(
    val status: Int,
    val message: String,
    val data: ErrorData?
)

data class ErrorData(
    val type: String,
    val code: Int,
    val message: String
)
