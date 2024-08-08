package com.example.appwithkoin.feature.homescreen.component
import BigBoxItem
import com.example.appwithkoin.feature.homescreen.data.model.response.Item
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun HomeBigLazyRow(
    url:String,
    listAllProduct:List<Item> = emptyList()
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(listAllProduct.size){
                index -> BigBoxItem(listAllProduct[index])
        }
    }
}