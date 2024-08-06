package com.example.appwithkoin.api
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductResponseItem
import retrofit2.Response
import retrofit2.http.GET

class  ServerRoute{
    companion object{
        const val  PRODUCT = "products"
    }
}
interface ApiService  {
    @GET(ServerRoute.PRODUCT)
    suspend fun getHomeProduct(): Response<List<ProductResponseItem>>
}