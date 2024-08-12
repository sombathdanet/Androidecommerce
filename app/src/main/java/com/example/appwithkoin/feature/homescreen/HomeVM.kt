package com.example.appwithkoin.feature.homescreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingData
import com.example.appwithkoin.feature.homescreen.data.network.model.response.MainCategoryData
import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepository
import com.example.appwithkoin.util.network.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data  class  HomeScreenState(
    val loading :Boolean = false,
    val listHomeTrending: List<HomeTrendingData> = emptyList(),
    val listMainCategory:List<MainCategoryData> = emptyList()
)

class  HomeScreenViewModel(private val productRepo:ProductRepository):ViewModel(){
    private  val _state = MutableStateFlow(HomeScreenState())
    val state : MutableStateFlow<HomeScreenState> get() = _state
    init {
        getCategoryHome()
        getHomeProductTrending()
    }
    private fun getCategoryHome(){
          viewModelScope.launch {
              productRepo.getMainCategory().collect {
                  when(it){
                      is DataState.Error<*> -> {
                          _state.value = _state.value.copy(
                              loading = false
                          )
                      }
                      is DataState.Loading -> {
                          _state.value = _state.value.copy(
                              loading = true
                          )
                      }
                      is DataState.Success -> {
                          _state.value = _state.value.copy(
                              loading = false,
                              listMainCategory = it.data
                          )
                      }
                  }
              }
          }
    }
    private  fun getHomeProductTrending(){
        viewModelScope.launch {
            productRepo.getHomeTrending().collect{
                when(it){
                    is DataState.Error<*> -> {
                        _state.value = _state.value.copy(
                            loading = false
                        )
                    }
                    is DataState.Loading -> {
                        _state.value = _state.value.copy(
                            loading = true
                        )
                    }
                    is DataState.Success -> {
                        _state.value = _state.value.copy(
                            listHomeTrending = it.data
                        )
                    }
                }
            }
        }
    }
}