package com.example.appwithkoin.feature.homescreen.component
import BigBoxItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingData
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingItem
import com.example.appwithkoin.util.XPadding

@Composable
fun HomeBigLazyRow(
    listAllProduct:List<HomeTrendingItem> = emptyList()
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(XPadding.Medium)
    ) {
        items(listAllProduct.size){
                index -> BigBoxItem(listAllProduct[index])
        }
    }
}