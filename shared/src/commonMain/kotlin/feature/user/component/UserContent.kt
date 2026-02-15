package feature.user.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import component.molecule.EmptyContent
import component.organism.ErrorContent
import component.molecule.LoadingContent
import github_user.shared.generated.resources.Res
import github_user.shared.generated.resources.global_error_retry
import github_user.shared.generated.resources.global_loading_message
import github_user.shared.generated.resources.ic_search
import github_user.shared.generated.resources.user_empty_message
import model.UiResult
import model.User
import org.jetbrains.compose.resources.stringResource

@Composable
fun UserContent(
    modifier: Modifier = Modifier,
    usersResult: UiResult<List<User>>,
    onItemClick: (User) -> Unit,
    onRetry: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (usersResult) {
            UiResult.Loading -> {
                LoadingContent(
                    message = stringResource(Res.string.global_loading_message)
                )
            }

            is UiResult.Success -> {
                val users = usersResult.data
                if (users.isEmpty()) {
                    EmptyContent(
                        resource = Res.drawable.ic_search,
                        message = stringResource(Res.string.user_empty_message)
                    )
                } else {
                    UserList(
                        users = users,
                        onItemClick =  onItemClick
                    )
                }
            }

            is UiResult.Error -> {
                ErrorContent(
                    message = usersResult.message,
                    resource = Res.drawable.ic_search,
                    retryButtonText = stringResource(Res.string.global_error_retry),
                    onRetry = onRetry
                )
            }

            UiResult.Idle -> Unit
        }
    }
}