package com.example.ss_team2.presentation.ui.othersPost


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ss_team2.R
import com.example.ss_team2.presentation.navigation.Screen
import com.example.ss_team2.presentation.ui.utility.TopBar
import com.example.ss_team2.presentation.ui.utility.TopBarButton
import com.example.ss_team2.presentation.viewModel.HelperViewModel
import com.example.ss_team2.presentation.viewModel.PostViewModel
import com.example.ss_team2.presentation.viewModel.UserViewModel
import com.example.ss_team2.ui.theme.TextGray

@Composable
fun LostListFinalScreen(
    modifier: Modifier = Modifier,
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {

    val otherUser by userViewModel.otherUser.collectAsState()

    Column(
        modifier = Modifier
    ) {
        TopBar(
            leftButton = {
                TopBarButton(
                    imageVector = Icons.Filled.ArrowBack,
                    onClick = { navController.popBackStack() }
                )
            },
            text = stringResource(id = R.string.LostList),
            rightButton = {
                Spacer(modifier = Modifier.size(40.dp))
            }
        )
        Divider(
            color = TextGray,
            thickness = 2.dp
        )
        Spacer(modifier = Modifier.height(16.dp))
        PostListLazyScreen(
            postOwner = otherUser.userName,
            helperViewModel = helperViewModel,
            postViewModel = postViewModel
        )
    }
}

@Composable
private fun OthersLostListBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController,
    where: String
) {
    val context = LocalContext.current
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )
            },
            label = {
                Text("地圖定位")
            },
            selected = true,
            onClick = {
                val gmmIntentUri =
                    Uri.parse("geo:120,24?q=$where")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            label = {
                Text("成功歸還")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            label = {
                Text("發送訊息")
            },
            selected = false,
            onClick = {
                navController.navigate(route = Screen.ChatRoom.route)
            }
        )
    }
}

@Composable
fun OthersLostListApp(
    helperViewModel: HelperViewModel,
    userViewModel: UserViewModel,
    postViewModel: PostViewModel,
    navController: NavController
) {
    Scaffold(
        bottomBar = { OthersLostListBottomNavigation(navController = navController, where = "台達館") }
    ) {
        LostListFinalScreen(
            helperViewModel = helperViewModel,
            userViewModel = userViewModel,
            postViewModel = postViewModel,
            navController = navController
        )
    }
}
