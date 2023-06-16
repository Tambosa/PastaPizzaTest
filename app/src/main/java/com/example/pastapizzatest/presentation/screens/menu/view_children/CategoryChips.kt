package com.example.pastapizzatest.presentation.screens.menu.view_children

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pastapizzatest.domain.model.MenuState
import com.example.pastapizzatest.presentation.screens.menu.MenuViewModel

@Composable
fun CategoryChips(
    modifier: Modifier = Modifier,
    menuState: MenuState,
    menuViewModel: MenuViewModel
) {
    LazyRow(
        modifier = modifier
    ) {
        items(count = MenuViewModel.FoodCategories.values().size, itemContent = { index ->
            Chip(
                name = stringResource(id = MenuViewModel.FoodCategories.values()[index].resId),
                isSelected = menuState.selectedCategory == MenuViewModel.FoodCategories.values()[index],
                onSelectionChanged = { menuViewModel.setSelectedCategory(MenuViewModel.FoodCategories.values()[index]) }
            )
        })
    }
}