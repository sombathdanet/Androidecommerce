package com.example.appwithkoin.feature.authscreen.loginscreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.appwithkoin.feature.authscreen.signupscreen.SignUpDestination
import com.example.appwithkoin.feature.homescreen.HomeDestination
import com.example.appwithkoin.feature.note.notehome.NoteDestination


object LoginDestination{
    const val  LOGIN_ROUTE = "login_route"
}

@RequiresApi(Build.VERSION_CODES.S)
fun NavGraphBuilder. addLoginRoute(
    navController: NavController
)
= composable(
    route = LoginDestination.LOGIN_ROUTE,
    content = {
        LoginScreen(
            setEffect = {
                when(it){
                    LoginContract.Effect.Nav.HomeRoute -> {
                        navController.navigate(HomeDestination.HOME_ROUTE)
                    }
                    LoginContract.Effect.Nav.SignUpRoute -> {
                        navController.navigate(SignUpDestination.SIGN_UP_ROUTE)
                    }

                    LoginContract.Effect.Nav.NoteHomeRoute -> {
                        navController.navigate(NoteDestination.NOTE_HOME_ROUTE)
                    }
                }
            }
        )
    }
)