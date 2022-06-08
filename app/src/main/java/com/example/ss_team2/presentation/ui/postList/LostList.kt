package com.example.ss_team2.presentation.ui.postList

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.utility.WhatAndWhereRowElement
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.ui.theme.SSteam2Theme



@Composable
fun HomeScreenWithMoney(
    postViewModel: PostViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.Loser),
            fontWeight = FontWeight.Bold,
            color = Color(0x66, 0x70, 0x80),
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp)
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp
        )
        Divider(
            color = Color(0x66, 0x70, 0x80),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        WhatAndWhereRowElement(
            what = stringResource(id = R.string.ball),
            where = stringResource(id = R.string.home)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostListLazyScreen(
            postType = "Lost",
            postViewModel = postViewModel,
            navController = navController
        )
    }

}

@Composable
fun FinalScreenWithMoney(
    postViewModel: PostViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        HomeScreenWithMoney(
            postViewModel = postViewModel,
            navController = navController
        )
        PostListButton(
            icon = Icons.Default.Add,
            onClick = { navController.navigate(route = Screen.AddLostList.route) },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        PostListButton(
            icon = Icons.Default.Home,
            onClick = { navController.navigate(route = Screen.Home.route) },
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    SSteam2Theme {
        FinalScreenWithMoney(navController = rememberNavController())
    }
}