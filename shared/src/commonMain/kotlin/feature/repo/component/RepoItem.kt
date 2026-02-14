package co.id.ilhamelmujib.githubuser.feature.repo.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.ic_call_split
import github_user.shared.generated.resources.ic_star
import github_user.shared.generated.resources.ic_visibility
import github_user.shared.generated.resources.repo_description_empty
import github_user.shared.generated.resources.repo_language_empty
import model.Repo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepoItem(repo: Repo, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(repo.htmlUrl)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = repo.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = repo.description.ifEmpty { stringResource(Res.string.repo_description_empty) },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = repo.language.ifEmpty { stringResource(Res.string.repo_language_empty) },
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(modifier = Modifier.height(12.dp))

                CounterSession(repo = repo)
            }
        }
        HorizontalDivider()
    }
}

@Composable
fun CounterSession(repo: Repo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CounterItem(icon = Res.drawable.ic_visibility, counterText = repo.watchersCount.toString())
        CounterItem(icon = Res.drawable.ic_star, counterText = repo.stargazersCount.toString())
        CounterItem(icon = Res.drawable.ic_call_split, counterText = repo.forksCount.toString())
    }
}

@Composable
fun CounterItem(
    icon: DrawableResource,
    counterText: String
) {
    Icon(
        painter = painterResource(icon),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = counterText,
        style = MaterialTheme.typography.bodySmall,
    )
    Spacer(modifier = Modifier.height(12.dp))
}