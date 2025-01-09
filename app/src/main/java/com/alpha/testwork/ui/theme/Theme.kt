package com.alpha.testwork.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = DarkSchemePrimary,
    secondary = DarkSchemeSecondary,
    tertiary = DarkSchemeTertiary,
    error = DarkSchemeError,
    primaryContainer = DarkSchemePrimaryContainer,
    secondaryContainer = DarkSchemeSecondaryContainer,
    tertiaryContainer = DarkSchemeTertiaryContainer,
    errorContainer = DarkSchemeErrorContainer,
    surface = DarkSchemeSurface
)

private val LightColorScheme = lightColorScheme(
    primary = LightSchemePrimary,
    secondary = LightSchemeSecondary,
    tertiary = LightSchemeTertiary,
    error = LightSchemeError,
    primaryContainer = LightSchemePrimaryContainer,
    secondaryContainer = LightSchemeSecondaryContainer,
    tertiaryContainer = LightSchemeTertiaryContainer,
    errorContainer = LightSchemeErrorContainer,
    surface = LightSchemeSurface
)

private val Shapes = Shapes(
    extraSmall = RoundedCornerShape(2),
    small = RoundedCornerShape(4),
    medium = RoundedCornerShape(6),
    large = RoundedCornerShape(8),
    extraLarge = RoundedCornerShape(10)
)

@Composable
fun AlphaTestAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}