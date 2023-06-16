package com.example.pastapizzatest.presentation.screens.common_ui

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pastapizzatest.presentation.Screen

@Composable
fun MyBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    bottomNavigationItems: List<Screen>
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
    ) {
        bottomNavigationItems.forEach { screen ->
            val isCurrentScreen = isCurrentScreen(navController, screen)
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(screen.icon),
                        tint = if (isCurrentScreen) {
                            MaterialTheme.colorScheme.onTertiaryContainer
                        } else {
                            MaterialTheme.colorScheme.onSecondaryContainer
                        },
                        contentDescription = screen.route
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = screen.name),
                        color = if (isCurrentScreen) {
                            MaterialTheme.colorScheme.onTertiaryContainer
                        } else {
                            MaterialTheme.colorScheme.onSecondaryContainer
                        },
                        style = MaterialTheme.typography.labelSmall,
                    )
                },
                selected = isCurrentScreen,
                alwaysShowLabel = true,
                onClick = {
                    if (!isCurrentScreen) {
                        navController.navigate(screen.route)
                    }
                })
        }
    }
}

@Composable
private fun isCurrentScreen(navController: NavHostController, screen: Screen): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return screen.route == navBackStackEntry?.destination?.route
}