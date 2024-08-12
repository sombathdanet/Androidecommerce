package com.example.appwithkoin.feature.homescreen.data.repository
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingData
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingResponse
import kotlinx.coroutines.flow.Flow
import com.example.appwithkoin.feature.homescreen.data.network.model.response.MainCategoryData
import com.example.appwithkoin.util.network.DataState


interface ProductRepository{
    suspend fun getMainCategory():Flow<DataState<List<MainCategoryData>>>
    suspend fun getHomeTrending():Flow<DataState<List<HomeTrendingData>>>
}