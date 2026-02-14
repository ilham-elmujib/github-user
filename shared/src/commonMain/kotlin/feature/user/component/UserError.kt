package feature.user.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun UserError(
    modifier: Modifier = Modifier,
    message: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Icon(
//            imageVector = Icons.Default.Warning,
//            contentDescription = null,
//            modifier = Modifier.size(64.dp),
//            tint = Color.Red
//        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = message ?: "Terjadi kesalahan sistem", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onRetry) {
            Text(text = "Coba Lagi")
        }
    }
}