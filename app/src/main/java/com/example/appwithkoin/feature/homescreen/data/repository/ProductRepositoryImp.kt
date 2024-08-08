package com.example.appwithkoin.feature.homescreen.data.repository
import ApiService
import com.example.appwithkoin.feature.homescreen.data.model.response.CategoryData
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductData

class   ProductRepositoryImp(
    private  val apiService: ApiService
): ProductRepository {
    override suspend fun getHomeProduct(): List<ProductData> {
        val res = apiService.getHomeProduct()
        if (res.isSuccessful){
            return  res.body()?.data ?: emptyList()
        }else{
            throw  Exception("Fail Fecth Daat")
        }
    }

    override suspend fun getCategoryProduct(): List<CategoryData> {
        val res = apiService.getCategories()
        if(res.isSuccessful){
            return  res.body()?.data?: emptyList()
        }else{
            throw  Exception("Fail Fecth Daat")
        }
    }
}
