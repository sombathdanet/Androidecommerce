import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appwithkoin.util.ColorApp

@Composable
fun CustomTextField(
    textState:MutableState<TextFieldValue>,
    icon:ImageVector,
    placeholder: String?
){
    TextField(
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        value =textState.value ,
        onValueChange ={
            textState.value = it
        },
        shape = RoundedCornerShape(20.dp),
        prefix = {
            Icon(
                imageVector = icon,
                contentDescription = ""
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor =ColorApp.whiteGray,
            focusedContainerColor = Color.White
        ),
        placeholder = {
            Text(
                text =placeholder?: "",
                modifier = Modifier.padding(start = 10.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight =  FontWeight.W400,
                )
            )
        }
    )
}