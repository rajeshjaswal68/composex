package `in`.digitalgears.composex.myUI

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun myNavigation(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "settings",
                        title = "Settings",
                        contentDescription = "Go to settings screen",
                        icon = Icons.Default.Settings
                    ),
                    MenuItem(
                        id = "help",
                        title = "Help",
                        contentDescription = "Get help",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "waterman",
                        title = "Waterman",
                        contentDescription = "Get Waterman",
                        icon = Icons.Default.Menu
                    ),
                    MenuItem(
                        id = "magazine",
                        title = "Magazine",
                        contentDescription = "Get Magazine",
                        icon = Icons.Default.ShoppingCart
                    ),
                ),
                onItemClick = {
                    println("Clicked on ${it.title}")
                    //MySump()
                }
            )
        }
    ){}

}