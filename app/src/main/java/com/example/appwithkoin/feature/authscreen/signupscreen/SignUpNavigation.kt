package com.example.appwithkoin.feature.authscreen.signupscreen
import SignUpScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

object SignUpDestination{
    const val  SIGN_UP_ROUTE = "sign_up_route"
}
@RequiresApi(Build.VERSION_CODES.S)
fun  NavGraphBuilder.addSignUpRoute(
    navController: NavController
) = composable(
    route = SignUpDestination.SIGN_UP_ROUTE,
    content = {
        SignUpScreen(
            setEffect = {
                when(it){
                    SignUpContract.Effect.Nav.Back -> {navController.popBackStack()}
                }
            }
        )
    }
)