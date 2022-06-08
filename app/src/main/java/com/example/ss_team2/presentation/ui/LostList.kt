package com.example.ss_team2.presentation.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.ui.theme.SSteam2Theme

@Composable
fun PostPreviewElementWithMoney(
    @DrawableRes drawable: Int,
    money: Int,
    @StringRes what: Int,
    @StringRes where: Int,
    @StringRes ItemText: Int,
    modifier: Modifier = Modifier,
    navController: NavController
){
    OutlinedButton(
        modifier = Modifier
            .width(335.dp)
            .height(145.dp),
        shape = RoundedCornerShape(12),
        onClick = {
                  navController.navigate(route = Screen.OthersLostList.route)
        },
        border = BorderStroke(1.dp, Color(0x66,0x70,0x80))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(1.dp),
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(RectangleShape)
            )
            WhatAndWhereColElement( stringResource(id = what), stringResource(id = where))
            Text(
                text = stringResource(id = ItemText),
                fontSize = 10.sp,
                color = Color(66,70,80),
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = "+ $money$",
            modifier = Modifier
                .align(Alignment.Bottom)
                .width(40.dp),
            fontSize = 12.sp
        )
    }
}

@Composable
fun LazyScreenWithMoney(modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy((8.dp))
    ) {
        items(PostPreviewData){
                item -> PostPreviewElementWithMoney(
            drawable = item.drawable, what = item.text,
            where = item.text,
            ItemText = item.text,
            money = 20,
            navController = navController
        )
        }
    }
}

@Composable
fun HomeScreenWithMoney(
    modifier: Modifier=Modifier,
    navController: NavController,
    what: String,
    where: String
){
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.Loser),
            fontWeight = FontWeight.Bold,
            color = Color(0x66,0x70,0x80),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Divider(color = Color(0x66,0x70,0x80), thickness = 1.dp)
        Spacer(modifier = Modifier.height(10.dp))
        WhatAndWhereRowElement(
            what = what,
            where = where
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyScreenWithMoney(navController = navController)
    }

}

@Composable
fun FinalScreenWithMoney(
    modifier: Modifier = Modifier,
    navController: NavController,
    what: String,
    where: String
){
    Box(modifier = Modifier.fillMaxSize()){
        HomeScreenWithMoney(navController = navController, what = what, where = where)
        OutlinedButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(100.dp)
                .padding(12.dp),
            onClick = {
                      navController.navigate(
                          route = Screen.AddLostList.passWhatAndWhere(
                              what = what,
                              where = where
                          )
                      )
            },
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.White, backgroundColor = Color(0x78,0x79,0xf1))
        ){
            Icon(Icons.Filled.Add,"")
        }
        OutlinedButton(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(100.dp)
                .padding(12.dp),
            onClick = {
                      navController.navigate(route = Screen.Home.route)
            },
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.White, backgroundColor = Color(0x78,0x79,0xf1))
        ){
            Icon(Icons.Filled.Home,"")
        }
    }
}

private val PostPreviewData = listOf(
    R.drawable.ic_launcher_foreground to R.string.ball,
    R.drawable.ic_launcher_foreground to R.string.ball,
    R.drawable.umbrella to R.string.home,
    R.drawable.umbrella to R.string.home,
    R.drawable.umbrella to R.string.home
).map { DrawableStringPair(it.first, it.second) }

