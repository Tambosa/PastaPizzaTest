package com.example.pastapizzatest.presentation.screens.menu.view_children

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pastapizzatest.domain.model.Pasta

@Composable
fun MenuItem(pasta: Pasta) {
    Row(modifier = Modifier.fillMaxWidth()) {
        PastaImage(pastaUrl = pasta.pastaImageUrl)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IMAGE_SIZE)
                .padding(start = 22.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = pasta.pastaName,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = pasta.pastaName + "\n" + pasta.id,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            MenuItemPrice(
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}
