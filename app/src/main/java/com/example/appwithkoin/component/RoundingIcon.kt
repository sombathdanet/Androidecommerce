package com.example.appwithkoin.component
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.appwithkoin.util.ColorApp
import com.example.appwithkoin.util.XPadding

@Composable
fun RoundedIcon(
    icon:  Painter,
    backGround: Color = ColorApp.mainColor,
    tintColor:Color = Color.White
) {
   Box(
       modifier = Modifier.background(
           color = backGround
       )
   ) {
       Image(
           painter = icon,
           contentDescription = "",
           colorFilter = ColorFilter.tint(color = tintColor),
           modifier = Modifier.size(16.dp).padding(XPadding.Large)
       )
   }
}