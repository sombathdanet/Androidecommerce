package com.example.appwithkoin.feature.authscreen.data.repository

import com.example.appwithkoin.feature.authscreen.data.model.body.LoginUserBodyModel
import com.example.appwithkoin.feature.authscreen.data.model.body.SignUpBodyModel
import com.example.appwithkoin.feature.authscreen.data.model.response.LoginUserResponse
import com.example.appwithkoin.feature.authscreen.data.model.response.SignUpResponse
import com.example.appwithkoin.util.network.DataState
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface  AuthRepository{
    suspend fun loginUser(body:LoginUserBodyModel):Flow<DataState<LoginUserResponse>>
    suspend fun signUpUser(body:SignUpBodyModel):Flow<DataState<SignUpResponse>>
}