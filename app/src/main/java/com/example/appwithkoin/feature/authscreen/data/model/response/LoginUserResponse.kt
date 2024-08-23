package com.example.appwithkoin.feature.authscreen.data.model.response

data class LoginUserResponse (
    val status: Long,
    val message: String,
    val data: AuthData
)

data class AuthData (
    val accessToken: String,
    val refreshToken: String,
    val issuedAt: Long,
    val expiresIn: Long,
    val tokenType: String
)