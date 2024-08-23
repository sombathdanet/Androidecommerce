package com.example.appwithkoin.feature.authscreen.data.model.body

data class SignUpBodyModel (
    val deviceInfo: String,
    val firstName: String,
    val lastName: String,
    val photoUrl: String,
    val username: String = firstName+lastName,
    val gender: String,
    val mobile: String,
    val mobileCode: String,
    val email: String,
    val password: String,
    val dateOfBirth: String,
    val region: String,
    val interests: List<Any?>
)
