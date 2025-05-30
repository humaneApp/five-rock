package com.hifeelingsapp.hifeelings

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hifeelingsapp.hifeelings.ui.theme.HiFeelingsTheme
import com.hifeelingsapp.hifeelings.userinterface.components.BottomNavigationBar
import com.hifeelingsapp.hifeelings.userinterface.screens.IFeelScreen
import com.hifeelingsapp.hifeelings.userinterface.screens.LetterScreen
import com.hifeelingsapp.hifeelings.userinterface.screens.SettingsScreen
import com.hifeelingsapp.hifeelings.userinterface.components.BottomNavItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiFeelingsTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "letters"

    val context = LocalContext.current
    var lastBackPressedTime by remember { mutableStateOf(0L) }

    BackHandler {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastBackPressedTime < 2000) {
            (context as Activity).finish()
        } else {
            lastBackPressedTime = currentTime
            Toast.makeText(context, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
    }

    val items = listOf(
        BottomNavItem("ifeel", "I Feel", Icons.Default.Search),
        BottomNavItem("letters", "Letters", Icons.Default.MailOutline),
        BottomNavItem("settings", "Settings", Icons.Default.Settings)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        val currentLabel = items.find { it.route == currentRoute }?.label ?: ""
                        Text(
                            text = currentLabel,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                },
                modifier = Modifier.height(80.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = items,
                currentRoute = currentRoute,
                onItemSelected = {
                    navController.navigate(it) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "letters",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("ifeel") { IFeelScreen() }
            composable("letters") { LetterScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}
