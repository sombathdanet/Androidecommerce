package com.example.appwithkoin.util
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun XTextExtraLarge(
    modifier: Modifier = Modifier,
    text:String = "",
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold,
    maxLine:Int = 1
){
    Text(
        modifier = modifier,
        text = text,
        maxLines =maxLine ,
        overflow = TextOverflow.Ellipsis,
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
    maxLine:Int = 1
){
    Text(
        modifier = modifier,
        text = text,
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis,
        style = TextStyle(
            color =color,
            fontSize = XFontSize.Large,
            fontWeight = fontWeight,

        )
    )
}
@Composable
fun XTextMedium(
    modifier: Modifier = Modifier,
    text:String = "",
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold,
    maxLine:Int = 1
){
    Text(
        modifier = modifier,
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLine,
        style = TextStyle(
            color =color,
            fontSize = XFontSize.Medium,
            fontWeight = fontWeight
        )
    )
}
@Composable
fun XTextSmall(
    modifier: Modifier = Modifier,
    text:String = "",
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold,
    maxLine:Int = 1
){
    Text(
        modifier = modifier,
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLine,
        style = TextStyle(
            color =color,
            fontSize = XFontSize.Small,
            fontWeight = fontWeight
        )
    )
}
