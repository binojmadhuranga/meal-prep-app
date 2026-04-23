package com.example.mealprepapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

import androidx.compose.ui.graphics.Color

val GreenPrimary = Color(0xFF4CAF50)
val GreenSecondary = Color(0xFF81C784)
val WhiteBackground = Color(0xFFFFFFFF)
private val LightColors = lightColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = WhiteBackground
)

@Composable
fun MealPrepAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}