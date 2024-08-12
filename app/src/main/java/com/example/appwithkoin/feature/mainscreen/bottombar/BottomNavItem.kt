package com.example.appwithkoin.feature.mainscreen.bottombar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appwithkoin.feature.homescreen.HomeDestination
import com.example.appwithkoin.feature.notification.NotificationDestination
import com.example.appwithkoin.feature.order.OrderDestination


sealed class BottomNavItem(
    title:String,
    route: String,
    icon: ImageVector
){
    data object Home:BottomNavItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = HomeDestination.HOME_ROUTE
    )
    data object Notification:BottomNavItem(
        title = "Notification",
        icon = Icons.Default.Notifications,
        route = NotificationDestination.NOTIFICATION_ROUTE
    )
    data object Order:BottomNavItem(
        title = "Order",
        icon = Icons.Default.ShoppingCart,
        route = OrderDestination.ORDER_ROUTE
    )
}
