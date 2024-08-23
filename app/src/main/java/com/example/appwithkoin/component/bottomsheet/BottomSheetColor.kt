package com.example.appwithkoin.component.bottomsheet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appwithkoin.core.color.hexToColor
import com.example.appwithkoin.util.XPadding

val listColor = listOf(
    "#ffffff",
    "#E87D66",
    "#ffdf4f",
    "#7feaac",
    "#ecb4cf",
    "#e23a08",
    "#9066ee",
)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ShowBottomSheet(
    selectIndex:Int =0,
    showBottomSheet:Boolean = false,
    onDismissRequest :() -> Unit,
    onChangeColor:(String) -> Unit = {},
    onChangeIndex:(Int) -> Unit  ={}
){

    if(showBottomSheet){
        ModalBottomSheet(
            containerColor = hexToColor(listColor[selectIndex]),
            onDismissRequest = {
                onDismissRequest()
            },
        ) {
            LazyRow(
                modifier = Modifier.padding(horizontal = XPadding.ExtraLarge).height(100.dp),
                horizontalArrangement = Arrangement.spacedBy(XPadding.Medium)
            ) {
                items(listColor.size){
                    i ->
                    val inColor = hexToColor(listColor[i])
                    Box (
                        modifier = Modifier
                            .size(50.dp)
                            .border(
                                width = 1.dp,
                                color = if (i == selectIndex) Color.Green.copy(alpha = 0.8f) else Color.Transparent,
                                shape = CircleShape
                            )
                            .clip(shape = CircleShape)
                            .background(
                                color = inColor,
                                shape = CircleShape
                            )
                            .clickable {
                                onChangeColor(listColor[i])
                                onChangeIndex(i)
                            },
                        contentAlignment = Alignment.Center
                    ){
                      if(selectIndex == i){
                          Icon(Icons.Default.Done, contentDescription = "", tint = Color.White)
                      }else{
                          Spacer(modifier = Modifier.size(0.dp))
                      }
                    }
                }
            }
        }
    }
}