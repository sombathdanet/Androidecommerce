package com.example.appwithkoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appwithkoin.feature.homescreen.HomeScreen
import com.example.appwithkoin.ui.theme.AppWithKoinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppWithKoinTheme {
                    HomeScreen()
            }
        }
    }
}
