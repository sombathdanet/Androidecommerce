package com.example.appwithkoin.feature.homescreen.data.repository
import android.provider.ContactsContract.Data
import kotlinx.coroutines.flow.Flow
import com.example.appwithkoin.feature.homescreen.data.network.NetworkData
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingData
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingResponse
import com.example.appwithkoin.feature.homescreen.data.network.model.response.MainCategoryData
import com.example.appwithkoin.util.network.DataState
import kotlinx.coroutines.flow.flow

class   ProductRepositoryImp(
    private  val homeNetworkData: NetworkData
): ProductRepository {

    override suspend fun getMainCategory(): Flow<DataState<List<MainCategoryData>>> = flow {
        emit(DataState.Loading)
        try {
            val res = homeNetworkData.getMainCategory()
            emit(DataState.Success(res.data))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }

    override suspend fun getHomeTrending(): Flow<DataState<List<HomeTrendingData>>> = flow {
        emit(DataState.Loading)
        try {
            val res = homeNetworkData.getTrendingHome()
            emit(DataState.Success(res.data))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
}
