package feature.users.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.users.component.UserList
import feature.users.component.UserTopBar
import co.id.ilhamelmujib.githubuser.feature.users.viewmodel.UserContract
import feature.users.component.UserError
import feature.users.component.UserLoading
import model.UiResult

@Composable
fun UserMobile(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State,
    snackBarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier,
        topBar = { UserTopBar() },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(it)) {
            when (uiState.userResult) {
                UiResult.Loading -> {
                    UserLoading()
                }

                is UiResult.Success -> {
                    UserList(
                        users = uiState.userResult.data,
                        onItemClick = {
                            onEvent(UserContract.Event.OnNavigateToRepo)
                        }
                    )
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
}