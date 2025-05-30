package com.hifeelingsapp.hifeelings.ui.theme

import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Color.Black,              // main interactive element color (buttons, etc.)
    onPrimary = Color.White,            // text/icon color on primary
    secondary = Color(0xFFAAAAAA),      // lighter gray (optional accent)
    onSecondary = Color.Black,
    background = Color.White,           // app background
    onBackground = Color.Black,
    surface = Color.White,        // card or surface (light gray)
    onSurface = Color.Black,
    surfaceVariant = Color.White, // gray hint or input background (light)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,
    secondary = Color(0xFF888888),      // gray for subtle contrast
    onSecondary = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = Color.Black,        // darker gray for cards
    onSurface = Color.White,
    surfaceVariant = Color(0xFF2E2E2E), // darker gray for hint or inputs
)



@Composable
fun HiFeelingsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme


    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )

    Log.d("ThemeCheck", "Current primary color: ${MaterialTheme.colorScheme.primary}")
    Log.d("ThemeCheck", "Current typography titleLarge: ${MaterialTheme.typography.titleLarge.fontFamily}")

}
