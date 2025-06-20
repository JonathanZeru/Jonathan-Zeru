package com.mpesa.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// My Custom light color scheme
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00695C),
    onPrimary = Color.White,
    background = Color(0xFFF1F1F1),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
)

// My Custom dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF80CBC4),
    onPrimary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,
)

// My Reusable Theme composable
@Composable
fun MyAppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(), // auto switch based on system
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(), // you can customize this too
        content = content
    )
}
