package co.id.ilhamelmujib.githubuser.feature.repo.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.ic_back
import github_user.shared.generated.resources.ic_close
import github_user.shared.generated.resources.repo_top_bar_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoTopBar(
    onBackPressed: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(Res.string.repo_top_bar_title)) },
        navigationIcon = {
            IconButton(
                onClick = { onBackPressed() }) {
                Icon(
                    painter = painterResource(Res.drawable.ic_back),
                    contentDescription = null
                )
            }
        }
    )
}