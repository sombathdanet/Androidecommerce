package com.example.appwithkoin.feature.homescreen.data.network
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingResponse
import com.example.appwithkoin.feature.homescreen.data.network.model.response.MainCategoryResponse
import retrofit2.http.GET

object ENDPOINT{
    const val GET_MAIN_CATEGORY = "get-all-category.php"
    const val GET_TREND_HOME = "get-product-home.php"
}
interface  NetworkData {
    @GET(value =ENDPOINT.GET_MAIN_CATEGORY )
    suspend fun getMainCategory(): MainCategoryResponse
    @GET(value = ENDPOINT.GET_TREND_HOME)
    suspend fun getTrendingHome():HomeTrendingResponse
}