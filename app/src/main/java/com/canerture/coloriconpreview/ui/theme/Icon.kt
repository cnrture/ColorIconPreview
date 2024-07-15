package com.canerture.coloriconpreview.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.canerture.coloriconpreview.R

class SampleProjectIcons {

    val home: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_home)

    val delete: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_delete)
}

internal val LocalIcons = staticCompositionLocalOf { SampleProjectIcons() }