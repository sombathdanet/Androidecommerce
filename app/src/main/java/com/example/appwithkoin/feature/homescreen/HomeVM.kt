package com.example.appwithkoin.feature.homescreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appwithkoin.feature.homescreen.data.model.response.CategoryData
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductData
import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data  class  HomeScreenState(
    val listCategory: List<CategoryData> = emptyList(),
    val listAllProduct: List<ProductData> = emptyList()
)
class  HomeScreenViewModel(private val productRepo:ProductRepository):ViewModel(){
    private  val _state = MutableStateFlow(HomeScreenState())
    val state : MutableStateFlow<HomeScreenState> get() = _state
    init {
        getCategoryHome()
    }
    private fun getCategoryHome(){
        viewModelScope.launch {
            val res = productRepo.getCategoryProduct()
            state.value = state.value.copy(
                listCategory = res
            )
            println(res.toString())
        }
    }
}