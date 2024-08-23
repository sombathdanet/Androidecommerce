package com.example.appwithkoin.core.color
import androidx.compose.ui.graphics.Color

fun hexToColor(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}