package component.atom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageAction
import com.seiko.imageloader.rememberImageSuccessPainter

@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    displayName: String,
    contentScale: ContentScale = ContentScale.Crop,
    backgroundColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    shape: Shape = MaterialTheme.shapes.small,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) {

    val action = rememberImageAction(imageUrl)
    val state = action.value

    Box(
        modifier = modifier
            .clip(shape)
            .background(
                color = backgroundColor,
            ),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is ImageAction.Success -> {
                Image(
                    painter = rememberImageSuccessPainter(state),
                    contentDescription = displayName,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape),
                    contentScale = contentScale
                )
            }

            else -> {
                val initials = displayName.split(" ")
                    .mapNotNull { it.firstOrNull()?.toString() }
                    .joinToString("")
                    .take(2)
                    .uppercase()

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = initials,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    color = contentColor,
                )
            }
        }
    }
}
