package co.id.ilhamelmujib.githubuser.feature.repo.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import component.atom.NetworkImage
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.repo_blog_dialog_not_found_button_ok
import github_user.shared.generated.resources.repo_blog_dialog_not_found_message
import github_user.shared.generated.resources.repo_blog_dialog_not_found_title
import github_user.shared.generated.resources.repo_button_see_all
import github_user.shared.generated.resources.repo_button_view_blog
import github_user.shared.generated.resources.repo_followers_title
import github_user.shared.generated.resources.repo_following_title
import github_user.shared.generated.resources.repo_location_empty
import github_user.shared.generated.resources.repo_score_title
import model.User
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepoListHeader(user: User) {

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ScoreSession(user)

            Spacer(modifier = Modifier.height(16.dp))

            UserDetailSession(user)

            Spacer(modifier = Modifier.height(16.dp))

            ButtonsSession(
                user = user,
                openUrl = {

                }
            )
        }

        HorizontalDivider(
            thickness = 0.5.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
    }
}

@Composable
fun ScoreSession(user: User) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NetworkImage(
            modifier = Modifier.size(100.dp),
            imageUrl = user.avatarUrl,
            displayName = user.name
        )

        ScoreItem(
            count = user.publicRepos,
            description = stringResource(Res.string.repo_score_title)
        )
        ScoreItem(
            count = user.followers,
            description = stringResource(Res.string.repo_followers_title)
        )
        ScoreItem(
            count = user.following,
            description = stringResource(Res.string.repo_following_title)
        )
    }
}

@Composable
fun UserDetailSession(user: User) {
    Text(
        text = user.name,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = user.location.ifEmpty { stringResource(Res.string.repo_location_empty) },
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
}

@Composable
fun ButtonsSession(
    user: User,
    openUrl: (String) -> Unit
) {

    val blogNotFoundDialog = remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = {
        }) {
            Text(text = stringResource(Res.string.repo_button_see_all))
        }

        Spacer(modifier = Modifier.width(12.dp))

        OutlinedButton(onClick = {
            if (user.blog.isEmpty()) {
                blogNotFoundDialog.value = true
            } else {
                openUrl(user.blog)
            }
        }) {
            Text(text = stringResource(Res.string.repo_button_view_blog))
        }
    }

    if (blogNotFoundDialog.value) {
        AlertDialog(
            onDismissRequest = {
                blogNotFoundDialog.value = false
            },
            title = {
                Text(text = stringResource(Res.string.repo_blog_dialog_not_found_title))
            },
            text = {
                Text(text = stringResource(Res.string.repo_blog_dialog_not_found_message))
            },
            confirmButton = {
                Text(
                    text = stringResource(Res.string.repo_blog_dialog_not_found_button_ok)
                )
            }
        )
    }
}

@Composable
fun ScoreItem(count: Int, description: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
    }
}
