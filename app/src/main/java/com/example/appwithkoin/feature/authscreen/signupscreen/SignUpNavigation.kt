package com.example.appwithkoin.feature.authscreen.signupscreen
import SignUpScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object SignUpDestination{
    const val  SIGN_UP_ROUTE = "sign_up_route"
}
fun  NavGraphBuilder.addSignUpRoute(
    navController: NavController
) = composable(
    route = SignUpDestination.SIGN_UP_ROUTE,
    content = {
        SignUpScreen()
    }
)