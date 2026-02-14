package feature.users.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.User
@Composable
fun UserList(
    modifier: Modifier = Modifier,
    users: List<User>,
    onItemClick: (User) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(users) { user ->
                UserItem(user = user, onItemClick = onItemClick)
            }
        }
    }
}