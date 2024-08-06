package com.example.appwithkoin.feature.homescreen.data.repository
import com.example.appwithkoin.api.ApiService
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductResponseItem

class   ProductRepositoryImp(
    private  val apiService: ApiService
): ProductRepository {
    override suspend fun getHomeProduct(): List<ProductResponseItem> {
        val res = apiService.getHomeProduct()
        if (res.isSuccessful){
            return  res.body() ?: emptyList()
        }else{
            throw  Exception("Fail Fecth Daat")
        }
    }
}
