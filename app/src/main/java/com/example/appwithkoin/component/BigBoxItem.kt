import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appwithkoin.feature.homescreen.data.model.response.Item
import com.example.appwithkoin.util.XTextLarge
import com.example.appwithkoin.util.XTextMedium

@Composable
fun BigBoxItem(
    item: Item
){
    Box (
        modifier = Modifier
            .height(300.dp)
            .width(180.dp)
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(15.dp)
            )
            .clip(
                shape = RoundedCornerShape(10.dp)
            )
    ){
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = item.image.last(),
            contentDescription =""
        )
        Icon(
            imageVector = Icons.Rounded.FavoriteBorder,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomEnd)
                .background(
                    Color.Black
                )
        ){
            Column(
                Modifier.fillMaxSize().padding(horizontal = 5.dp, vertical = 5.dp)
            ) {
                XTextMedium(modifier = Modifier, text = item.title)
                XTextLarge(modifier = Modifier, text = "$ ${item.price}")
            }
        }
    }
}