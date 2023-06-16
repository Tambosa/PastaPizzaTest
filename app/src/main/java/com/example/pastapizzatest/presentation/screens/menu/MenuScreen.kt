package com.example.pastapizzatest.presentation.screens.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pastapizzatest.presentation.screens.menu.view_children.Chip
import com.example.pastapizzatest.presentation.screens.menu.view_children.MenuItem

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    menuViewModel: MenuViewModel = hiltViewModel()
) {
    LaunchedEffect(true) { menuViewModel.getMenu() }
    val menuState by menuViewModel.menuState.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        ) {
            items(count = MenuViewModel.FoodCategories.values().size, itemContent = { index ->
                Chip(
                    name = stringResource(id = MenuViewModel.FoodCategories.values()[index].resId),
                    isSelected = menuState.selectedCategory == MenuViewModel.FoodCategories.values()[index],
                    onSelectionChanged = { menuViewModel.setSelectedCategory(MenuViewModel.FoodCategories.values()[index]) }
                )
            })
        }
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(count = menuState.pastaList.size,
                itemContent = { index ->
                    MenuItem(menuState.pastaList[index])
                }
            )
        }
    }
}