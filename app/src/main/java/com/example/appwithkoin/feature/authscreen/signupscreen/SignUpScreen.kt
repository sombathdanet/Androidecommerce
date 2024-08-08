
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import com.example.appwithkoin.component.CustomButton
import com.example.appwithkoin.feature.authscreen.component.AuthTextField
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextExtraLarge

@Composable
internal  fun SignUpScreen(){
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val pass = remember { mutableStateOf(TextFieldValue("")) }
    SignUpContent(
        email = email,
        pass = pass
    )
}
@Composable
fun SignUpContent(
    email: MutableState<TextFieldValue> =remember { mutableStateOf(TextFieldValue("")) },
    pass: MutableState<TextFieldValue> = remember { mutableStateOf(TextFieldValue("")) },
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
            text = "Sign In"
        )
        Spacer(modifier = Modifier.height(XPadding.ExtraLarge))
    }
}