package com.example.pastapizzatest.presentation.screens.menu.view_children

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pastapizzatest.domain.model.MenuState

@Composable
fun MenuContent(
    modifier: Modifier,
    menuScrollState: LazyListState,
    menuState: MenuState
) {
    LazyColumn(
        modifier = modifier,
        state = menuScrollState,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(count = menuState.pastaList.size,
            itemContent = { index ->
                MenuItem(menuState.pastaList[index])
            }
        )
    }
}