package com.example.appwithkoin.feature.homescreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object HomeDestination{
    const val  HOME_ROUTE = "home_route"
}
fun NavGraphBuilder.addHomeRoute(
    navController: NavController
) = composable(
    route =HomeDestination.HOME_ROUTE,
    content = {
        HomeScreen()
    }
)