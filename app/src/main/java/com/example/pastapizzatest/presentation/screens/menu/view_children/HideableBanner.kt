package com.example.pastapizzatest.presentation.screens.menu.view_children

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun HideableBanners(modifier: Modifier, isVisible: Boolean) {
    AnimatedVisibility(visible = isVisible) {
        LazyRow(
            modifier = modifier
                .height(112.dp),
        ) {
            items(count = 10, itemContent = {
                EmptyBanner()
            })
        }
    }
}

@Composable
private fun EmptyBanner() {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .padding(start = 8.dp, end = 8.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = Color(
                alpha = 255,
                red = Random.nextInt(256),
                green = Random.nextInt(256),
                blue = Random.nextInt(256),
            )
        )
    ) {
        //nothing
    }
}