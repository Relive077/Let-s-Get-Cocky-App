package app.web.relive.letsgetcocky.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = Purple500,
    secondary = Teal500,
    background = Color.White,
    surface = Gray100
)

private val DarkThemeColors = darkColors(
    primary = Purple700,
    secondary = Teal700,
    background = Color.Black,
    surface = Gray900
)

@Composable
fun LetsGetCockyTheme(
    lightTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (lightTheme) LightThemeColors else DarkThemeColors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}