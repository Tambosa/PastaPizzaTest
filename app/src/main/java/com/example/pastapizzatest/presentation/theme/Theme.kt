package com.example.pastapizzatest.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primaryContainer = ContainerPrimary,
    secondaryContainer = SurfaceNavigation,
    tertiaryContainer = SurfaceSelected,
    primary = TextPrimary,
    secondary = TextSecondary,
    onTertiaryContainer = onSurfaceSelected,
    tertiary = TextInactive,
)

private val LightColorScheme = lightColorScheme(
    primaryContainer = ContainerPrimary,
    secondaryContainer = SurfaceNavigation,
    tertiaryContainer = SurfaceSelected,
    onSecondaryContainer = IconInactive,
    primary = TextPrimary,
    secondary = TextSecondary,
    onTertiaryContainer = onSurfaceSelected,
    tertiary = TextInactive,
)

@Composable
fun PastaPizzaTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primaryContainer.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}