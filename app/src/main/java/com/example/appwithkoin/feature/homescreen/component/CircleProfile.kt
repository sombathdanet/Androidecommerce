package com.example.appwithkoin.feature.homescreen.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CircleProfile(url:String){
    AsyncImage(
        modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp).size(50.dp).clip(
            shape = CircleShape
        ).fillMaxSize(),
        model =url , contentDescription = "",
        contentScale = ContentScale.Crop
    )
}