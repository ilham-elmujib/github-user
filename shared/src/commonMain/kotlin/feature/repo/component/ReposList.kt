package co.id.ilhamelmujib.githubuser.feature.repo.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.Repo

@Composable
fun RepoList(
    header: @Composable () -> Unit,
    repos: List<Repo>,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item { header() }
            items(repos) { repo ->
                RepoItem(
                    repo = repo,
                    onItemClick = {

                    }
                )
            }
        }
    }
}