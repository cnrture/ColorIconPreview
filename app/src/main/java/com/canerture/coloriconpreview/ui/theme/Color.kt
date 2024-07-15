package com.canerture.coloriconpreview.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

fun lightColors(
    primary: Color = Color(0xFF000000),
    primaryContainer: Color = Color(0xFFFFFFFF),
): SampleProjectColor = SampleProjectColor(
    primary = primary,
    primaryContainer = primaryContainer,
)

fun darkColors(
    primary: Color = Color(0xFFFFFFFF),
    primaryContainer: Color = Color(0xFF000000),
): SampleProjectColor = SampleProjectColor(
    primary = primary,
    primaryContainer = primaryContainer,
)

class SampleProjectColor(
    primary: Color,
    primaryContainer: Color,
) {
    private var _primary: Color by mutableStateOf(primary)
    val primary: Color = _primary

    private var _primaryContainer: Color by mutableStateOf(primaryContainer)
    val primaryContainer: Color = _primaryContainer

    private class KelpColorPreview {
        val primary_FF000000_FFFFFFFF = Unit
        val primaryContainer_FFFFFFFF_FF000000 = Unit
    }
}

internal val LocalColors = staticCompositionLocalOf { lightColors() }