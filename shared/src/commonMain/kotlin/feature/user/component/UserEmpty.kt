package feature.user.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UserEmpty(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Icon(
//            imageVector = Icons.Default.Search,
//            contentDescription = null,
//            modifier = Modifier.size(64.dp),
//            tint = Color.Gray
//        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "User tidak ditemukan", color = Color.Gray)
    }
}