package com.example.pastapizzatest.presentation.screens.menu

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pastapizzatest.presentation.Screen

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    menuViewModel: MenuViewModel = hiltViewModel()
) {
    LaunchedEffect(true) { menuViewModel.getMenu() }
    val menuState by menuViewModel.menuState.collectAsState()
    Log.d("@@@", "MenuScreen: ${menuState.toString()}")
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(id = Screen.Menu.name),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}