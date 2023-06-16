package com.example.pastapizzatest.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.pastapizzatest.R

sealed class Screen(val route: String, @StringRes val name: Int, @DrawableRes val icon: Int) {
    object Menu : Screen("Menu", R.string.menu, R.drawable.ic_menu)
    object Profile : Screen("Profile", R.string.profile, R.drawable.ic_profile)
    object Cart : Screen("Cart", R.string.cart, R.drawable.ic_cart)
}