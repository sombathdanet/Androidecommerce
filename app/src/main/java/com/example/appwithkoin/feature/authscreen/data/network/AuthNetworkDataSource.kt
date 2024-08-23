package com.example.appwithkoin.feature.authscreen.data.network

import com.example.appwithkoin.core.base.BaseResponse
import com.example.appwithkoin.feature.authscreen.data.model.body.LoginUserBodyModel
import com.example.appwithkoin.feature.authscreen.data.model.body.SignUpBodyModel
import com.example.appwithkoin.feature.authscreen.data.model.response.LoginUserResponse
import com.example.appwithkoin.feature.authscreen.data.model.response.SignUpResponse
import com.example.appwithkoin.feature.authscreen.signupscreen.SignUpVM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthNetworkDataSource{
    @POST(value = AuthEndPoint.POST_LOGIN_USER_USERNAME)
    suspend fun loginUser(@Body body:LoginUserBodyModel):Response<LoginUserResponse>
    @POST(value =AuthEndPoint.POST_SIGN_UP_USER)
    suspend fun signUpUser(@Body body:SignUpBodyModel) :Response<SignUpResponse>
}