package component

import androidx.compose.runtime.Composable

@Composable
fun ResponsiveContent(
    compact: @Composable () -> Unit,
    expand: @Composable () -> Unit
) {
    val isLargeScreen = LocalIsLargeScreen.current

    if (isLargeScreen) {
        expand()
    } else {
        compact()
    }

}
