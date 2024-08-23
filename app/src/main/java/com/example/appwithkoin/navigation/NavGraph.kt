package com.example.appwithkoin.navigation
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.appwithkoin.feature.authscreen.loginscreen.LoginDestination
import com.example.appwithkoin.feature.authscreen.loginscreen.addLoginRoute
import com.example.appwithkoin.feature.authscreen.signupscreen.addSignUpRoute
import com.example.appwithkoin.feature.homescreen.addHomeRoute
import com.example.appwithkoin.feature.note.creatnote.addCreateNoteRoute
import com.example.appwithkoin.feature.note.notehome.addNoteHomeRoute


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navHostController,
        startDestination = LoginDestination.LOGIN_ROUTE
    ){
        addLoginRoute(navController = navHostController)
        addHomeRoute(navController = navHostController)
        addSignUpRoute(navController = navHostController)
        //addBottomNavigationGraph(navController = navHostController)
        addNoteHomeRoute(navController = navHostController)
        addCreateNoteRoute(navController = navHostController)
    }
}