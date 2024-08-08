package com.example.appwithkoin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextMedium

@Composable
fun CustomButton(
    text:String="",
    onClick:() ->Unit = {}
){
    Box (
        modifier = Modifier.fillMaxWidth()
            .background(color = Color(0xff8e6cef), shape = CircleShape)
            .clip(shape = CircleShape)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ){
        XTextMedium(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(XPadding.ExtraLarge)
        )
    }
}