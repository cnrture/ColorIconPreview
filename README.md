# ColorIconPreview
Color and Icon Previews in Autocompletion

## Youtube Video


## Setup
Install Kelp Plugin -> https://github.com/ozontech/kelp

### .idea/kelp/config.json
```kotlin
{
  "colorPreview": {
    "codeCompletionEnabled": true,
    "gutterEnabled": true
  },
  "iconsRendering": {
    "codeCompletionEnabled": true,
    "gutterEnabled": true,
    "containerClassName": "com.canerture.coloriconpreview.ui.theme.SampleProjectIcons",
    "propertyToResourceMapper": {
      "addPrefix": "ic_",
      "convertToSnakeCase": true
    }
  }
}
```

### Color.kt
```kotlin
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
```

### Icon.kt
```kotlin
class SampleProjectIcons {

    val home: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_home)

    val delete: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_delete)
}

internal val LocalIcons = staticCompositionLocalOf { SampleProjectIcons() }
```

### Theme.kt
```kotlin
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
```

## Result
https://github.com/user-attachments/assets/1e680dc6-ece6-401e-be89-784ebebed4fe
