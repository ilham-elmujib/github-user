package feature.repo.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import component.atom.NetworkImage
import github_user.shared.generated.resources.*
import model.User
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepoListHeader(
    modifier: Modifier = Modifier,
    user: User,
    onSeeAllClick: (String) -> Unit,
    onViewBlogClick: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ScoreSession(user)
            UserDetailSession(user)
            ButtonsSession(
                user = user,
                onSeeAllClick = onSeeAllClick,
                onViewBlogClick = onViewBlogClick
            )
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
    }
}

@Composable
private fun ScoreSession(user: User) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NetworkImage(
            modifier = Modifier.size(80.dp),
            imageUrl = user.avatarUrl,
            displayName = user.name
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ScoreItem(user.publicRepos, stringResource(Res.string.repo_score_title))
            ScoreItem(user.followers, stringResource(Res.string.repo_followers_title))
            ScoreItem(user.following, stringResource(Res.string.repo_following_title))
        }
    }
}

@Composable
private fun UserDetailSession(user: User) {
    Column {
        Text(
            text = user.name,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = user.bio.ifBlank { stringResource(Res.string.repo_bio_empty) },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ButtonsSession(
    user: User,
    onSeeAllClick: (String) -> Unit,
    onViewBlogClick: (String) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = {
                onSeeAllClick.invoke(user.htmlUrl)
            },
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(Res.string.repo_button_see_all))
        }

        OutlinedButton(
            onClick = {
                if (user.blog.isBlank()) showDialog = true
                else onViewBlogClick(user.blog)
            },
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(Res.string.repo_button_view_blog))
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(Res.string.repo_blog_dialog_not_found_title)) },
            text = { Text(stringResource(Res.string.repo_blog_dialog_not_found_message)) },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(Res.string.repo_blog_dialog_not_found_button_ok))
                }
            }
        )
    }
}

@Composable
private fun ScoreItem(count: Int, description: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}