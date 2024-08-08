package com.example.appwithkoin.feature.authscreen.component
import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.appwithkoin.util.XFontSize
import com.example.appwithkoin.util.XPadding

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    onValueChange:(TextFieldValue) -> Unit ={},
    value: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue()) },
    hintText:String ="",
    keyboardActions: KeyboardActions = KeyboardActions(onDone = null)
){
   Box(
       modifier = modifier
           .fillMaxWidth()
           .background(
               color = Color(0xfff4f4f4)
           )
           .clip(
               shape = RoundedCornerShape(10)
           ),
           contentAlignment = Alignment.Center
   ) {
       Row(
           modifier = Modifier.fillMaxWidth().padding(vertical = XPadding.ExtraLarge),
           verticalAlignment = Alignment.CenterVertically,
           horizontalArrangement = Arrangement.spacedBy(XPadding.Small)
       ){
           BasicTextField(
               cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
               modifier = Modifier.fillMaxWidth().padding(start = XPadding.Small),
               value = value.value,
               onValueChange ={
                   value.value = it
                   onValueChange(it)
               },
               decorationBox = { innerTextField ->
                   if(value.value.text.isEmpty()){
                       Text(
                           text = hintText,
                           style = TextStyle(
                               color = Color.LightGray,
                               fontSize = XFontSize.Medium,
                               fontWeight = FontWeight.SemiBold,
                           )
                       )
                   }
                   innerTextField()
               },
               keyboardActions = keyboardActions,
               textStyle = TextStyle(
                   color = Color.LightGray,
                   fontSize = XFontSize.Medium,
                   fontWeight = FontWeight.SemiBold
               ),
               maxLines = 1
           )
       }
   }
}
@Composable
@Preview(showBackground = true)
private fun   AuthTextFieldPreview(){
    val value = remember {
        mutableStateOf(TextFieldValue(""))
    }
    AuthTextField(
        value = value,
        hintText = "Username"
    )
}