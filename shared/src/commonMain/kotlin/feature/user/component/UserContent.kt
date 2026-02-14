package co.id.ilhamelmujib.githubuser.feature.users.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.user.viewmodel.UserContract
import component.molecule.EmptyContent
import component.organism.ErrorContent
import feature.user.component.UserList
import component.molecule.LoadingContent
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.global_error_retry
import github_user.shared.generated.resources.global_loading_message
import github_user.shared.generated.resources.ic_search
import github_user.shared.generated.resources.user_empty_message
import model.UiResult
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserContent(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (uiState.usersResult) {
            UiResult.Loading -> {
                LoadingContent(
                    message = stringResource(Res.string.global_loading_message)
                )
            }

            is UiResult.Success -> {
                val users = uiState.usersResult.data
                if (users.isEmpty()) {
                    EmptyContent(
                        resource = Res.drawable.ic_search,
                        message = stringResource(Res.string.user_empty_message)
                    )
                } else {
                    UserList(
                        users = users,
                        onItemClick = {
                            onEvent(UserContract.Event.OnNavigateToRepo(it.login))
                        }
                    )
                }
            }

            is UiResult.Error -> {
                ErrorContent(
                    message = uiState.usersResult.message,
                    resource = Res.drawable.ic_search,
                    retryButtonText = stringResource(Res.string.global_error_retry),
                    onRetry = {
                        onEvent(UserContract.Event.OnRetry)
                    }
                )
            }

            UiResult.Idle -> Unit
        }
    }
}