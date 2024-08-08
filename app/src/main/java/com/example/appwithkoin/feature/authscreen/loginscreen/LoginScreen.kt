package com.example.appwithkoin.feature.authscreen.loginscreen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.appwithkoin.component.CustomButton
import com.example.appwithkoin.feature.authscreen.component.AuthTextField
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextExtraLarge
import com.example.appwithkoin.util.XTextMedium
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
internal  fun LoginScreen(
    event: (LoginContract.LoginEvent) -> Unit
){
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val pass = remember { mutableStateOf(TextFieldValue("")) }
    val vm: LoginVM = koinViewModel()

    LoginContent(
        email = email,
        pass = pass,
        vm = vm,
        event = event
    )

    LaunchedEffect(Unit) {
        vm.navigationEvent.collect { navigationEvent ->
            event(navigationEvent)
        }
    }
}
@Composable
fun LoginContent(
    email: MutableState<TextFieldValue> =remember { mutableStateOf(TextFieldValue("")) },
    pass: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue("")) },
    vm:LoginVM,
    event: (LoginContract.LoginEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = XPadding.ExtraLarge),
        verticalArrangement = Arrangement.Center,
    ) {
        XTextExtraLarge(
            text = "Sign In",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(XPadding.ExtraLarge))
        AuthTextField(
            value = email,
            hintText = "Email"
        )
        Spacer(modifier = Modifier.height(XPadding.Medium))
        AuthTextField(
            value = pass,
            hintText = "Password"
        )
        Spacer(modifier = Modifier.height(XPadding.ExtraLarge))
        CustomButton(
            text = "Sign In",
            onClick = {
                vm.gotoHome()
            }
        )
        Spacer(modifier = Modifier.height(XPadding.ExtraLarge))
        NoAcc(
            event = event
        )
    }
}
@Composable
fun NoAcc(
    event: (LoginContract.LoginEvent) -> Unit
){
    Row(
        horizontalArrangement = Arrangement.spacedBy(XPadding.Small)
    ) {
        XTextMedium(
          text =  "Don't have account ?",
            fontWeight = FontWeight.W400
        )
        XTextMedium(
            text =  "Sign Up",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                event(LoginContract.LoginEvent.SignUp)
            }
        )
    }
}
@Composable
@Preview(showBackground = true)
private  fun LoginContentPr(){
   // LoginContent()
}
