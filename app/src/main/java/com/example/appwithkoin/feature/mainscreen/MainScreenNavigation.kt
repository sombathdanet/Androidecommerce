package com.example.appwithkoin.feature.mainscreen
import android.app.Notification
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appwithkoin.feature.homescreen.HomeDestination
import com.example.appwithkoin.feature.notification.NotificationDestination
import com.example.appwithkoin.feature.order.OrderDestination

object MainDestination{
    const val  MAIN_ROUT = "main_route"
}

fun NavGraphBuilder.addMainScreen(
    navController: NavController
) = composable(
    route = MainDestination.MAIN_ROUT,
    content = {
        MainScreen(
            event = {
                when(it){
                    MainScreenContract.MainEvent.HomeRoute -> {
                        navController.navigate(HomeDestination.HOME_ROUTE)
                    }
                    MainScreenContract.MainEvent.NotificationRoute -> {
                        navController.navigate(NotificationDestination.NOTIFICATION_ROUTE)
                    }
                    MainScreenContract.MainEvent.OrderRoute -> {
                        navController.navigate(OrderDestination.ORDER_ROUTE)
                    }
                }
            }
        )
    }
)