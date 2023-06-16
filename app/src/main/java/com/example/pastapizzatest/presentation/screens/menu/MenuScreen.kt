package com.example.pastapizzatest.presentation.screens.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pastapizzatest.presentation.screens.menu.view_children.CategoryChips
import com.example.pastapizzatest.presentation.screens.menu.view_children.HideableBanners
import com.example.pastapizzatest.presentation.screens.menu.view_children.MenuContent
import com.example.pastapizzatest.presentation.screens.menu.view_children.MenuHeader

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    menuViewModel: MenuViewModel = hiltViewModel()
) {
    val menuState by menuViewModel.menuState.collectAsState()
    val menuScrollState = rememberLazyListState()
    val isBannerVisible by remember { derivedStateOf { menuScrollState.firstVisibleItemIndex == 0 } }

    LaunchedEffect(true) { menuViewModel.getMenu() }

    Column(modifier = modifier.fillMaxSize()) {
        MenuHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        HideableBanners(
            modifier = Modifier.fillMaxWidth(),
            isVisible = isBannerVisible
        )
        CategoryChips(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            menuState = menuState,
            menuViewModel = menuViewModel
        )
        MenuContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            menuScrollState = menuScrollState,
            menuState = menuState
        )
    }
}