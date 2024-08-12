import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appwithkoin.feature.homescreen.data.network.model.response.HomeTrendingItem
import com.example.appwithkoin.util.ColorApp
import com.example.appwithkoin.util.XPadding
import com.example.appwithkoin.util.XTextLarge
import com.example.appwithkoin.util.XTextMedium
import com.example.appwithkoin.util.XTextSmall
import com.example.appwithkoin.util.rememberImageHeight
import com.example.appwithkoin.util.rememberImageWidth

@Composable
fun BigBoxItem(
    item: HomeTrendingItem
){
    val height = rememberImageHeight()
    val width = rememberImageWidth()
    Column {
        Box (
            modifier = Modifier
                .width(width)
                .background(
                    color = Color.Gray,
                    shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
                )
                .clip(
                    shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
                )
        ){
            AsyncImage(
                modifier = Modifier.height(height),
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

        }
        Box (
            modifier = Modifier
                .width(width)
                .clip(
                    shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                )
        ){
            Column(
                Modifier
                    .fillMaxSize()
                    .background(color = ColorApp.whiteGray)
                    .padding(horizontal = XPadding.Medium, vertical =  XPadding.Medium),
                verticalArrangement = Arrangement.spacedBy(XPadding.Small)
            ) {
                XTextSmall(modifier = Modifier, text = item.title, fontWeight = FontWeight.W400)
                XTextSmall(modifier = Modifier, text = "$ ${item.price}", fontWeight = FontWeight.Bold)
            }
        }
    }

}