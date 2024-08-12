package com.example.appwithkoin.feature.homescreen

import CustomTextField
import LazyRowHome
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appwithkoin.feature.homescreen.component.CircleProfile
import com.example.appwithkoin.feature.homescreen.component.HomeBigLazyRow
import com.example.appwithkoin.feature.homescreen.component.TitleRow
import com.example.appwithkoin.util.ColorApp
import com.example.appwithkoin.util.XPadding
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
internal fun HomeScreen(){
    val vm : HomeScreenViewModel = koinViewModel()
    HomeContent(
        vm.state.collectAsState()
    )
}
@Composable
fun HomeContent(state: State<HomeScreenState>) {
    Scaffold(
        topBar = {
            Row(
                Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                CircleProfile(
                    url = "https://i.pinimg.com/564x/b9/bb/c7/b9bbc72381c315bde9a515640ce23b29.jpg"
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 15.dp)
                        .background(
                            color = ColorApp.whiteGray,
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    Text(
                        text = "Men",
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                            .background(color = ColorApp.whiteGray),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(horizontal = 15.dp, vertical = 15.dp)
                        .size(50.dp)
                        .background(
                            color = ColorApp.mainColor,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(

                        Icons.Rounded.ShoppingCart,
                        tint = Color.White,
                        contentDescription ="",
                        modifier = Modifier.clickable {

                        }
                    )
                }
            }
        }
    ) {
            paddingValues -> BuildBody(
                paddingValues,
                state = state
            )
    }
}
@Composable
private  fun BuildBody(
    paddingValues: PaddingValues,
    state: State<HomeScreenState>
) {
    val searchState = remember {
        mutableStateOf(TextFieldValue(""))
    }

    LazyColumn(
        modifier = Modifier
            .padding(
                paddingValues = paddingValues
            )
            .padding(
                horizontal = XPadding.ExtraLarge
            ),
        verticalArrangement = Arrangement.spacedBy(XPadding.Large)
    ) {
        item {
               CustomTextField(
                   textState = searchState,
                   icon = Icons.Rounded.Search
                   ,"Search",)
        }
        item {
            TitleRow(firstTitle = "Categories", secondTitle = "SeeAll")
        }
        item{
                LazyRowHome(
                    listCategory = state.value.listMainCategory
                )
        }
        items(state.value.listHomeTrending){
            TitleRow(firstTitle = it.title)
            Spacer(modifier = Modifier.height(XPadding.Large))
            HomeBigLazyRow(
                listAllProduct = it.items
            )
        }
    }
}