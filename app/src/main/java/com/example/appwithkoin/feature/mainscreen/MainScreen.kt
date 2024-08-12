package com.example.appwithkoin.feature.mainscreen

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.appwithkoin.feature.mainscreen.bottombar.BottomNavItem

@Composable
fun MainScreen(
    event: (MainScreenContract.MainEvent) -> Unit
){
    MainScreen (event = event)
}
@Composable
private  fun  MainContent(
    event: (MainScreenContract.MainEvent) -> Unit
){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {BottomBar(event = event)}
    ){
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}



@Composable
private  fun BottomBar(
    event: (MainScreenContract.MainEvent) -> Unit
){
    val screens = listOf(
        BottomNavItem.Home,
        BottomNavItem.Notification,
        BottomNavItem.Order
    )
}