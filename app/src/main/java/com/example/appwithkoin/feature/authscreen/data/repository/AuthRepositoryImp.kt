package com.example.appwithkoin.feature.authscreen.data.repository
import android.annotation.SuppressLint
import com.example.appwithkoin.core.network.retrofitErrorHandler
import com.example.appwithkoin.feature.authscreen.data.model.body.LoginUserBodyModel
import com.example.appwithkoin.feature.authscreen.data.model.body.SignUpBodyModel
import com.example.appwithkoin.feature.authscreen.data.model.response.LoginUserResponse
import com.example.appwithkoin.feature.authscreen.data.model.response.SignUpResponse
import com.example.appwithkoin.feature.authscreen.data.network.AuthNetworkDataSource
import com.example.appwithkoin.util.network.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow



class AuthRepositoryImp(
    private  val authNetworkDataSource: AuthNetworkDataSource
):AuthRepository{
 //   @SuppressLint("SuspiciousIndentation")
    override suspend fun loginUser(body:LoginUserBodyModel): Flow<DataState<LoginUserResponse>> = flow {
        emit(DataState.Loading)
      try {
        val res = retrofitErrorHandler(authNetworkDataSource.loginUser(body = body))
          emit(DataState.Success(res))
        }catch (e:Exception){
            emit(DataState.Error(e.message.toString()))
        }

    }

    override suspend fun signUpUser(body: SignUpBodyModel): Flow<DataState<SignUpResponse>> = flow{
        emit(DataState.Loading)
        try {
            val res = retrofitErrorHandler(authNetworkDataSource.signUpUser(body = body))
            emit(DataState.Success(res))
        }catch (e:Exception){
            emit(DataState.Error(e.message.toString()))
        }
    }

}