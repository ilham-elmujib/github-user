package co.id.ilhamelmujib.githubuser.feature.users.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.user.viewmodel.UserContract
import feature.user.component.UserEmpty
import feature.user.component.UserError
import feature.user.component.UserList
import feature.user.component.UserLoading
import model.UiResult

@Composable
fun UserContent(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (uiState.userResult) {
            UiResult.Loading -> {
                UserLoading()
            }

            is UiResult.Success -> {
                val users = uiState.userResult.data
                if (users.isEmpty()) {
                    UserEmpty()
                } else {
                    UserList(
                        users = users,
                        onItemClick = {
                            onEvent(UserContract.Event.OnNavigateToRepo)
                        }
                    )
                }
            }

            is UiResult.Error -> {
                UserError(
                    message = uiState.userResult.message,
                    onRetry = {

                    }
                )
            }

            UiResult.Idle -> Unit
        }
    }
}