package com.example.appwithkoin.component.appbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.appwithkoin.R
import com.example.appwithkoin.component.RoundedIcon
import com.example.appwithkoin.util.XTextMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XTitleTopBar(
    modifier: Modifier = Modifier,
    title:String,
    isNavBack:Boolean = false
) {
   TopAppBar(
       modifier = modifier,
       navigationIcon = {
           if(isNavBack){
               RoundedIcon(icon = painterResource(id = R.drawable.ic_back))
           }else{
               Spacer(modifier = Modifier.padding(0.dp))
           }
       },
       title = {
           XTextMedium(
               text = title
           )
       }
   )
}