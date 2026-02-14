package co.id.ilhamelmujib.githubuser.feature.repo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Repo

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
            itemsIndexed(repos) { index, repo ->
                RepoItem(
                    repo = repo,
                    onItemClick = onItemClick
                )
                if (index < repos.lastIndex) {
                    HorizontalDivider(
                        thickness = 0.5.dp,
                    )
                }
            }
        }
    }
}