package com.example.appwithkoin.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberImageHeight():Dp{
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    return  remember {
        screenHeight.div(3.5.dp).dp
    }
}
@Composable
fun rememberImageWidth():Dp{
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    return remember {
        screenWidth.div(2.5.dp).dp
    }
}