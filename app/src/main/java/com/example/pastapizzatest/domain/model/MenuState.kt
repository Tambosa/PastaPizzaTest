package com.example.pastapizzatest.domain.model

import com.example.pastapizzatest.presentation.screens.menu.MenuViewModel

data class MenuState(
    val isLoading: Boolean = false,
    val selectedCategory: MenuViewModel.FoodCategories = MenuViewModel.FoodCategories.values()[0],
    val pastaList: List<Pasta> = listOf()
)