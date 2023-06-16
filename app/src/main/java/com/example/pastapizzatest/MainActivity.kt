package com.example.pastapizzatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pastapizzatest.presentation.Screen
import com.example.pastapizzatest.presentation.screens.CartScreen
import com.example.pastapizzatest.presentation.screens.ProfileScreen
import com.example.pastapizzatest.presentation.screens.common_ui.MyBottomNavigation
import com.example.pastapizzatest.presentation.screens.menu.MenuScreen
import com.example.pastapizzatest.presentation.theme.PastaPizzaTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PastaPizzaTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    val navController = rememberNavController()
                    val bottomNavigationItems = listOf(
                        Screen.Menu,
                        Screen.Profile,
                        Screen.Cart,
                    )
                    Scaffold(
                        bottomBar = {
                            MyBottomNavigation(
                                navController = navController,
                                bottomNavigationItems = bottomNavigationItems
                            )
                        },
                    ) { contentPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Menu.route
                        ) {
                            val screenModifier = Modifier.padding(
                                top = contentPadding.calculateTopPadding(),
                                bottom = contentPadding.calculateBottomPadding()
                            )
                            composable(
                                route = Screen.Menu.route
                            ) {
                                MenuScreen(
                                    modifier = screenModifier
                                )
                            }
                            composable(
                                route = Screen.Profile.route,
                            ) {
                                ProfileScreen(
                                    modifier = screenModifier
                                )
                            }
                            composable(
                                route = Screen.Cart.route
                            ) {
                                CartScreen(
                                    modifier = screenModifier
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

val COLLAPSED_TOP_BAR_HEIGHT = 56.dp
val EXPANDED_TOP_BAR_HEIGHT = 200.dp