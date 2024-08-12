package com.example.appwithkoin.feature.homescreen.component
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appwithkoin.util.XTextLarge
import com.example.appwithkoin.util.XTextMedium

@Composable
fun TitleRow(
    firstTitle:String,
    secondTitle:String = "SeeAll",
    firstColor:Color = Color.Black
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        XTextLarge(
            modifier = Modifier, text = firstTitle,
            color = firstColor
        )
        XTextMedium(
            modifier = Modifier,
            text = secondTitle,)
    }
}