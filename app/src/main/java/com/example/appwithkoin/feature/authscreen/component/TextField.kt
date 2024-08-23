package com.example.appwithkoin.feature.authscreen.component
import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appwithkoin.util.XFontSize
import com.example.appwithkoin.util.XPadding
import java.lang.Error

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    modifierText: Modifier =Modifier,
    onValueChange:(String) -> Unit ={},
    newValue: String = "",
    hintText:String ="",
    keyboardActions: KeyboardActions = KeyboardActions(onDone = null),
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage:String? = null,
    borderColor: Color? = null,
    singleLine: Boolean = false,
    backGroundColor:Color = Color.White,
){

    val interactionSource = remember { MutableInteractionSource() }

    val isFocus by interactionSource.collectIsFocusedAsState()

    val colorBorder = if(isError) Color.Red else if(isFocus) Color.Blue else Color.LightGray


    Column(
       modifier  = modifier.background(backGroundColor)
   ) {
           BasicTextField(
               cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
               modifier = modifierText,
               value = newValue,
               onValueChange ={
                   onValueChange(it)
               },
               interactionSource = interactionSource,
               decorationBox = { innerTextField ->
                   Row(
                       modifier = Modifier
                           .border(
                               width = 0.1.dp,
                               color = borderColor ?: colorBorder,
                               shape = RoundedCornerShape(8.dp)
                           )
                           .background(
                               color = backGroundColor,
                               shape = RoundedCornerShape(8.dp)
                           )

                   ){
                       if(leadingIcon != null){
                           leadingIcon()
                       }else Spacer(modifier = Modifier.padding(horizontal = XPadding.Small))
                      Box(
                          modifier = Modifier.padding(vertical =XPadding.ExtraLarge)
                      ) {
                          if (newValue.isEmpty()) {
                              Text(
                                  text = hintText,
                                  style = MaterialTheme.typography.bodySmall,
                                  color = Color.LightGray,
                              )
                          }
                          Box(modifier = modifier.fillMaxWidth()){
                              innerTextField()
                          }
                      }
                   }

               },
               keyboardActions = keyboardActions,
               textStyle = TextStyle(
                   color = Color.LightGray,
                   fontSize = XFontSize.Medium,
                   fontWeight = FontWeight.SemiBold
               ),
               singleLine = singleLine,
           )
           if(isError) {
               Text(
                   text = errorMessage?:"",
                   color = MaterialTheme.colorScheme.error,
                   style = MaterialTheme.typography.bodySmall,
               )
           }else Spacer(modifier = Modifier.size(0.dp))
   }
}
@Composable
@Preview(showBackground = true)
private fun   AuthTextFieldPreview(){
    val value = remember {
        mutableStateOf(TextFieldValue(""))
    }
    AuthTextField(
        newValue = value.value.text,
        hintText = "Username"
    )
}