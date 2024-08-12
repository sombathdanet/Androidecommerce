package com.example.appwithkoin.feature.notification

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object  NotificationDestination{
    const val  NOTIFICATION_ROUTE = "notification_route"
}

fun NavGraphBuilder.addNotificationRoute(
    navController: NavController
) = composable(
    route = NotificationDestination.NOTIFICATION_ROUTE,
    content = {
        NotificationScreen()
    }
)