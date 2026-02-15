package feature.user.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import feature.repo.component.RepoList
import feature.repo.component.RepoListHeader
import component.molecule.EmptyContent
import component.molecule.LoadingContent
import component.organism.ErrorContent
import feature.user.viewmodel.UserContract
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.global_error_retry
import github_user.shared.generated.resources.global_loading_message
import github_user.shared.generated.resources.ic_search
import github_user.shared.generated.resources.repo_empty_message
import github_user.shared.generated.resources.user_select_message
import model.UiResult
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserDetailContent(
    modifier: Modifier = Modifier,
    uiState: UserContract.State,
    onEvent: (UserContract.Event) -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
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
                                onEvent(UserContract.Event.OnNavigateToBrowser(it))
                            },
                            onViewBlogClick = {
                                onEvent(UserContract.Event.OnNavigateToBrowser(it))

                            }
                        )
                    },
                    repos = data.repos,
                    onItemClick = {
                        onEvent(UserContract.Event.OnNavigateToBrowser(it))
                    }
                )
            }

            is UiResult.Error -> {
                ErrorContent(
                    message = uiState.reposResult.message,
                    resource = Res.drawable.ic_search,
                    retryButtonText = stringResource(Res.string.global_error_retry),
                    onRetry = {
                        onEvent(UserContract.Event.OnRetryGetUserDetail)
                    }
                )
            }

            UiResult.Idle -> Text(
                text = stringResource(Res.string.user_select_message)
            )
        }
    }
}