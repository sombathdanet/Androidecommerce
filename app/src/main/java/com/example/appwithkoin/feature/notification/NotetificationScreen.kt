package com.example.appwithkoin.feature.notification
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.appwithkoin.R
import com.example.appwithkoin.component.appbar.XTitleTopBar
import com.example.appwithkoin.util.XTextLarge

@Composable
fun NotificationScreen(

) {
    NotificationContent()
}
@Composable
private  fun NotificationContent(){
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            XTitleTopBar(title = "Notification")
        }
    ) {
       paddingValues ->  BuildBody(
           paddingValues
       )
    }
}
@Composable
private  fun BuildBody(
    paddingValues: PaddingValues
) {
    EmptyNotification()
}
@Composable
private  fun EmptyNotification(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground)
            , contentDescription ="", colorFilter = ColorFilter.tint(color = Color.Yellow)
        )
        XTextLarge(
            text = "No Notification yet",
            fontWeight = FontWeight.W400
        )
    }
}