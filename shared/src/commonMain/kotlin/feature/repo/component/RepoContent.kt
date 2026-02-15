package co.id.ilhamelmujib.githubuser.feature.repo.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import component.molecule.EmptyContent
import component.molecule.LoadingContent
import component.organism.ErrorContent
import feature.repo.component.RepoList
import feature.repo.component.RepoListHeader
import feature.repo.viewmodel.RepoContract
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.global_error_retry
import github_user.shared.generated.resources.global_loading_message
import github_user.shared.generated.resources.ic_search
import github_user.shared.generated.resources.repo_empty_message
import model.UiResult
import org.jetbrains.compose.resources.stringResource

@Composable
fun RepoContent(
    modifier: Modifier = Modifier,
    onEvent: (RepoContract.Event) -> Unit,
    uiState: RepoContract.State
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (uiState.reposResult) {
            UiResult.Loading -> {
                LoadingContent(
                    message = stringResource(Res.string.global_loading_message)
                )
            }

            is UiResult.Success -> {
                val data = uiState.reposResult.data
                RepoList(
                    header = {
                        RepoListHeader(
                            user = data.user,
                            onSeeAllClick = {
                                onEvent(RepoContract.Event.OnNavigateToBrowser(it))
                            },
                            onViewBlogClick = {
                                onEvent(RepoContract.Event.OnNavigateToBrowser(it))

                            }
                        )
                    },
                    repos = data.repos,
                    onItemClick = {
                        onEvent(RepoContract.Event.OnNavigateToBrowser(it))
                    }
                )
            }

            is UiResult.Error -> {
                ErrorContent(
                    message = uiState.reposResult.message,
                    resource = Res.drawable.ic_search,
                    retryButtonText = stringResource(Res.string.global_error_retry),
                    onRetry = {
                        onEvent(RepoContract.Event.OnRetry)
                    }
                )
            }

            UiResult.Idle -> Unit
        }
    }
}