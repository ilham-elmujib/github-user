package feature.user.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import model.User
import component.atom.NetworkImage

@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    user: User,
    onItemClick: (User) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(user)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            NetworkImage(
                modifier = Modifier.size(45.dp),
                shape = CircleShape,
                imageUrl = user.avatarUrl,
                displayName = user.login,
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = user.login,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = user.htmlUrl,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}