package com.example.appwithkoin.util
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
@Composable
fun XTextExtraLarge(
    modifier: Modifier = Modifier,
    text:String = "",
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            color =color,
            fontSize = XFontSize.ExtraLarge,
            fontWeight = fontWeight
        )
    )
}
@Composable
fun XTextLarge(
    modifier: Modifier = Modifier,
    text:String = "",
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold,
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            color =color,
            fontSize = XFontSize.Large,
            fontWeight = fontWeight
        )
    )
}
@Composable
fun XTextMedium(
    modifier: Modifier = Modifier,
    text:String = "",
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold,
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            color =color,
            fontSize = XFontSize.Medium,
            fontWeight = fontWeight
        )
    )
}
