package co.id.ilhamelmujib.githubuser.feature.repo.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun RepoItem(
    modifier: Modifier = Modifier,
    repo: Repo,
    onItemClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick(repo.htmlUrl) }
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = repo.name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = repo.description.ifBlank { stringResource(Res.string.repo_description_empty) },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = repo.language.ifBlank { stringResource(Res.string.repo_language_empty) },
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        RepoStatsRow(repo)
    }
}

@Composable
private fun RepoStatsRow(repo: Repo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 4.dp)
    ) {
        StatItem(Res.drawable.ic_visibility, repo.watchersCount.toString())
        StatItem(Res.drawable.ic_star, repo.stargazersCount.toString())
        StatItem(Res.drawable.ic_call_split, repo.forksCount.toString())
    }
}

@Composable
private fun StatItem(icon: DrawableResource, count: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = MaterialTheme.colorScheme.outline
        )
        Text(
            text = count,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.outline
        )
    }
}