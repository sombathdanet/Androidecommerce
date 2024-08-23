
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.appwithkoin.component.CustomButton
import com.example.appwithkoin.component.ShowAlertDialog
import com.example.appwithkoin.feature.authscreen.component.AuthTextField
import com.example.appwithkoin.feature.authscreen.signupscreen.SignUpContract
import com.example.appwithkoin.feature.authscreen.signupscreen.SignUpVM
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextExtraLarge
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(KoinExperimentalAPI::class)
@Composable
internal  fun SignUpScreen(
    setEffect:(SignUpContract.Effect.Nav) -> Unit
){
    val vm :SignUpVM = koinViewModel()
    SignUpContent(
        vm,
        setEvent = vm::setEvent
    )
    LaunchedEffect(Unit) {
        vm.effect.onEach {
            when(it){
                is SignUpContract.Effect.Nav -> setEffect(it)
            }
        }.collect()
    }
}
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun SignUpContent(
    vm: SignUpVM,
    setEvent:(SignUpContract.SignupEvent) -> Unit,
    ) {
    val state = vm.uiState.collectAsState()
    ShowAlertDialog(
        showDialog = state.value.isError,
        message = state.value.message,
        onClickButton = {
            vm.setError(false)
        },
        onDismissRequest = {
            vm.setError(false)
        }
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = XPadding.ExtraLarge),
        verticalArrangement = Arrangement.Center,
    ) {
       item {
           Column (
               verticalArrangement =Arrangement.spacedBy(XPadding.Medium)
           ){
               XTextExtraLarge(
                   text = "Sign In",
                   fontWeight = FontWeight.Bold
               )
               Spacer(modifier = Modifier.height(XPadding.ExtraLarge))
               AuthTextField(
                   newValue = state.value.fistName,
                   hintText = "First Name",
                   onValueChange = {
                       setEvent(SignUpContract.SignupEvent.FirstNameChangeEvent(it))
                   },
                   isError = state.value.firstNameError != null,
                   errorMessage = state.value.firstNameError
               )
               AuthTextField(
                   newValue = state.value.lastName,
                   hintText = "Last Name",
                   isError = state.value.lastNameError != null,
                   onValueChange = {
                       setEvent(SignUpContract.SignupEvent.LastChangeEvent(it))
                   },
                   errorMessage = state.value.lastNameError
               )
               AuthTextField(
                   newValue = state.value.email,
                   hintText = "Email",
                   isError = state.value.emailError != null,
                   onValueChange = {
                       setEvent(SignUpContract.SignupEvent.EmailChangeEvent(it))
                   },
                   errorMessage = state.value.emailError
               )
               AuthTextField(
                   newValue = state.value.password,
                   hintText = "Password",
                   isError =state.value.passwordError != null,
                   onValueChange = {
                       setEvent(SignUpContract.SignupEvent.PasswordChangeEvent(it))
                   },
                   errorMessage = state.value.passwordError
               )
               AuthTextField(
                   newValue = state.value.phone,
                   hintText = "Phone Number",
                   isError = state.value.phoneError  != null,
                   onValueChange = {
                       setEvent(SignUpContract.SignupEvent.PhoneChangeEvent(it))
                   },
                   errorMessage = state.value.phoneError
               )
               CustomButton(
                   text = "Sign Up",
                   onClick = {
                       vm.signUpUser()
                   }
               )
               Spacer(modifier = Modifier.height(XPadding.ExtraLarge))
           }
       }
    }
}