package com.example.appwithkoin.feature.authscreen.loginscreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.appwithkoin.component.CustomButton
import com.example.appwithkoin.component.ShowAlertDialog
import com.example.appwithkoin.feature.authscreen.component.AuthTextField
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextExtraLarge
import com.example.appwithkoin.util.XTextMedium
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import kotlin.reflect.KProperty0

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(KoinExperimentalAPI::class)
@Composable
internal  fun LoginScreen(
    setEffect : (LoginContract.Effect.Nav) -> Unit
){
    val vm: LoginVM = koinViewModel()

    LoginContent(
        vm = vm,
        event = vm::setEvent
    )
    LaunchedEffect(Unit) {
        vm.effect.onEach {
            when(it){
                is LoginContract.Effect.Nav -> setEffect(it)
            }
        }.collect()
    }
}
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun LoginContent(
    vm:LoginVM,
    event:(LoginContract.LoginEvent) -> Unit
) {

    val state = vm.uiState.collectAsState()
    ShowAlertDialog(
        showDialog = state.value.message != null,
        message = state.value.message,
        onClickButton = {
            vm.setMessage(null)
        },
        onDismissRequest = {
            vm.setMessage(null)
        }
    )
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
            newValue = state.value.email,
            hintText = "Email",
            onValueChange = {
                vm.handleEvent(LoginContract.LoginEvent.EmailChange(it))
            },
            isError = state.value.errorEmail != null,
            errorMessage = state.value.errorEmail,
            leadingIcon = { Icon(
                Icons.Default.Email , contentDescription = "",
                tint = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = XPadding.Small),
            ) }
        )
        Spacer(modifier = Modifier.height(XPadding.Medium))
        AuthTextField(
            newValue = state.value.pass,
            hintText = "Password",
            onValueChange = {
                vm.handleEvent(LoginContract.LoginEvent.PassChange(it))
            },
            isError = state.value.errorPass != null,
            errorMessage = state.value.errorPass,
            leadingIcon = { Icon(
                Icons.Default.Lock , contentDescription = "",
                tint = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = XPadding.Small),
            ) }
        )
        Spacer(modifier = Modifier.height(XPadding.Medium))
        CustomButton(
            text = "Sign In",
            onClick = {
                vm.loginUserWithUserPass()
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
