package component.template

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

/**
 * A responsive layout wrapper for Compose Multiplatform (KMP).
 * * This component automatically switches between different layout strategies
 * based on the available window width, following Material Design breakpoints.
 *
 * @param mobile The UI content to display on compact screens (e.g., smartphones, < 600dp).
 * @param tablet The UI content to display on medium to expanded screens (e.g., tablets or desktops, >= 600dp).
 */
@Composable
fun ResponsiveContent(
    mobile: @Composable () -> Unit,
    tablet: @Composable () -> Unit,
) {
    BoxWithConstraints {
        val width = maxWidth

        when {
            // Standard breakpoint for Material Design Window Size Classes
            width < 600.dp -> mobile()
            else -> tablet()
        }
    }
}