package com.canerture.coloriconpreview.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object SampleProjectTheme {
    val colors: SampleProjectColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val icons: SampleProjectIcons
        @Composable
        @ReadOnlyComposable
        get() = LocalIcons.current
}

@Composable
fun SampleProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides if (darkTheme) darkColors() else lightColors(),
        LocalIcons provides SampleProjectTheme.icons
    ) {
        content()
    }
}