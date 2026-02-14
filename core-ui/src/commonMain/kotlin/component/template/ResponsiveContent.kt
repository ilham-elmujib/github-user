package component.template

import androidx.compose.runtime.Composable
import component.LocalIsLargeScreen

@Composable
fun ResponsiveContent(
    mobile: @Composable () -> Unit,
    tablet: @Composable () -> Unit
) {
    val isLargeScreen = LocalIsLargeScreen.current

    if (isLargeScreen) {
        tablet()
    } else {
        mobile()
    }

}
