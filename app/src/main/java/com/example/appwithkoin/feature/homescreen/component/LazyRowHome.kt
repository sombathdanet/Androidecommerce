import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.appwithkoin.feature.homescreen.data.model.response.CategoryData

@Composable
fun LazyRowHome(
    url:String="",
    listCategory: List<CategoryData> = emptyList(),
    onClick:()-> Unit ={},
    selectIndex :(Int) -> Unit ={}
){
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(listCategory.size){
                index ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier.clickable(
                        onClick ={
                            onClick()
                            selectIndex(index)
                        })
                        .size(70.dp)
                        .clip(
                            shape = CircleShape
                        )
                        .fillMaxSize(),
                    model = listCategory[index].images[0] , contentDescription ="",
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}