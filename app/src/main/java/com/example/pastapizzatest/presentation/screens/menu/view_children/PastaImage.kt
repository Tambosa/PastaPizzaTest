package com.example.pastapizzatest.presentation.screens.menu.view_children

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.pastapizzatest.R

@Composable
fun PastaImage(pastaUrl: String) {

    val imageModifier = Modifier
        .height(IMAGE_SIZE)
        .width(IMAGE_SIZE)
        .clip(shape = MaterialTheme.shapes.medium)

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(pastaUrl)
            .crossfade(true)
            .size(Size.ORIGINAL)
            .build(),
    )

    when (painter.state) {
        is AsyncImagePainter.State.Success -> {
            Image(
                modifier = imageModifier,
                painter = painter,
                contentDescription = null
            )
        }

        is AsyncImagePainter.State.Loading -> {
            Box(
                modifier = imageModifier,
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        else -> {
            ContextCompat.getDrawable(LocalContext.current, R.drawable.ic_menu)?.let {
                Image(
                    modifier = imageModifier,
                    bitmap = it.toBitmap().asImageBitmap(),
                    contentDescription = null
                )
            }
        }
    }
}

val IMAGE_SIZE = 135.dp