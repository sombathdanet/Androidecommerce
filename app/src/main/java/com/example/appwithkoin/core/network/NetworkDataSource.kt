package com.example.appwithkoin.core.network
import android.util.Log
import com.example.appwithkoin.core.base.ErrorResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServerRoute {
    const val  BASE_URL = "https://dev-api.kiloit.com/travel/"
}

internal fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(ServerRoute.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttpClient())
        .build()
}
internal fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}
internal  fun <T> retrofitErrorHandler(res: Response<T>): T {
    if (res.isSuccessful) {
        return res.body()!!
    } else {
        val gson = GsonBuilder()
        val create = gson.create()
        var errorMessage = "Unknown Error"

        try {
            val json  = create.fromJson(res.errorBody()?.charStream(), ErrorResponse::class.java)
            errorMessage = json.data?.message ?: "Unknown Error"
        }catch (e:Exception){
            errorMessage = "Unknown Error"
        }
        throw  Exception(errorMessage);
    }

}