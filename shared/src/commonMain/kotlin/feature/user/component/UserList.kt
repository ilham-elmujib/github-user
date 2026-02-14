package feature.user.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.User

@Composable
fun UserList(
    modifier: Modifier = Modifier,
    users: List<User>,
    onItemClick: (User) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(users) { index, user ->
            UserItem(user = user, onItemClick = onItemClick)
            if (index < users.lastIndex) {
                HorizontalDivider(
                    thickness = 0.5.dp,
                )
            }
        }
    }
}