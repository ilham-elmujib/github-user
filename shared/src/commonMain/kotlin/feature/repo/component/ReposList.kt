package feature.repo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.id.ilhamelmujib.githubuser.feature.repo.component.RepoItem
import component.molecule.EmptyContent
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.ic_search
import github_user.shared.generated.resources.repo_empty_message
import model.Repo
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepoList(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    repos: List<Repo>,
    onItemClick: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item { header() }
            if (repos.isEmpty()) {
                item {
                    EmptyContent(
                        resource = Res.drawable.ic_search,
                        message = stringResource(Res.string.repo_empty_message)
                    )
                }
            } else {
                itemsIndexed(
                    items = repos,
                    key = { _, repo -> repo.id }
                ) { index, repo ->
                    RepoItem(
                        repo = repo,
                        onItemClick = onItemClick
                    )

                    if (index < repos.lastIndex) {
                        HorizontalDivider(thickness = 0.5.dp)
                    }
                }
            }
        }
    }
}