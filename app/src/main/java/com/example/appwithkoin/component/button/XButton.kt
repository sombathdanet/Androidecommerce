package com.example.appwithkoin.component.button
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appwithkoin.util.XPadding

@Composable
fun XButton(
    modifier: Modifier = Modifier,
    backGroundColor:Color = Color.White,
    tintColor:Color = Color.White,
    imageVector: ImageVector
){
    Box(
        modifier = modifier.background(
            color = backGroundColor,
            shape = CircleShape
        ).clip(
            shape = CircleShape
        )
            .clickable {

            }
    ){
        Icon(
            imageVector =  imageVector,
            contentDescription = "",
            modifier = Modifier.padding(XPadding.Medium),
            tint = tintColor
        )
    }
}