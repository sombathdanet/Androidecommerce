package com.example.appwithkoin.navigation
import com.example.appwithkoin.feature.mainscreen.addMainScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.appwithkoin.feature.homescreen.HomeDestination
import com.example.appwithkoin.feature.homescreen.addHomeRoute
import com.example.appwithkoin.feature.notification.addNotificationRoute
import com.example.appwithkoin.feature.order.addOrderRoute

const val  BOTTOM_ROUTE = "bottom_navigation_route"

fun NavGraphBuilder.addBottomNavigationGraph(
    navController: NavController
){
    navigation(
        startDestination = HomeDestination.HOME_ROUTE,
        route = BOTTOM_ROUTE
    ) {
        addMainScreen(navController = navController)
        addHomeRoute(navController = navController)
        addNotificationRoute(navController = navController)
        addOrderRoute(navController = navController)
    }
}