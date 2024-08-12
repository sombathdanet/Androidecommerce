package com.example.appwithkoin.feature.order
import OrderScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object  OrderDestination{
    const val  ORDER_ROUTE = "order_route"
}

fun NavGraphBuilder.addOrderRoute(
    navController: NavController
) = composable(
    route = OrderDestination.ORDER_ROUTE,
    content = {
        OrderScreen()
    }
)