package com.example.appwithkoin.feature.authscreen.loginscreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appwithkoin.feature.authscreen.signupscreen.SignUpDestination
import com.example.appwithkoin.feature.homescreen.HomeNavigation


object LoginDestination{
    const val  LOGIN_ROUTE = "login_route"
}

fun NavGraphBuilder. addLoginRoute(
    navController: NavController
)
= composable(
    route = LoginDestination.LOGIN_ROUTE,
    content = {
        LoginScreen(
            event = {
                when(it){
                    LoginContract.LoginEvent.HomeRoute -> {
                        navController.navigate(HomeNavigation.HOME_ROUTE)
                    }
                    LoginContract.LoginEvent.SignUp -> {
                        navController.navigate(SignUpDestination.SIGN_UP_ROUTE)
                    }
                }
            }
        )
    }
)