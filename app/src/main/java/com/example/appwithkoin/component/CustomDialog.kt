package com.example.appwithkoin.component
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextMedium

@Composable
fun ShowAlertDialog(
    showDialog: Boolean = false,
    onDismissRequest: () -> Unit ={},
    onClickButton :() -> Unit ={},
    message:String? = null,
    buttonTitle:String= "ok"
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = {
                onDismissRequest()
            },
            content = {
                Box(
                    modifier = Modifier
                        .height(120.dp)
                        .padding(vertical = XPadding.ExtraLarge)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clip(
                            shape = RoundedCornerShape(5.dp)
                        )
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                      XTextMedium(
                          text = message?: "Some thing wrong",
                          color = Color.LightGray,
                          fontWeight = FontWeight.W400
                      )
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(XPadding.Medium)
                                .clickable {
                                    onClickButton()
                                }
                                .background(
                                    color = Color.White,
                                    shape = CircleShape
                                )
                        ) {
                            XTextMedium(
                                modifier = Modifier.padding(vertical = XPadding.Medium, horizontal = XPadding.Large),
                                text = buttonTitle,
                                color = Color.Red,
                                fontWeight = FontWeight.W400
                            )
                        }
                    }
            }
        )
    }
}