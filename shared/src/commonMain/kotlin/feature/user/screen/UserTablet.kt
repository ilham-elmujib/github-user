package feature.user.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.user.component.UserContent
import feature.user.component.UserDetailContent
import feature.user.component.UserSearchBar
import feature.user.viewmodel.UserContract

@Composable
fun UserTablet(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State,
    snackBarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            UserSearchBar(
                uiState = uiState,
                onEvent = onEvent
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        Row(
            modifier = Modifier
                .padding(it)
                .padding(top = 8.dp)
                .fillMaxSize()
        ) {
            UserContent(
                modifier = Modifier.weight(0.5f),
                usersResult = uiState.usersResult,
                onItemClick = { user ->
                    onEvent(UserContract.Event.OnSelectUserItem(user.login))
                },
                onRetry = {
                    onEvent(UserContract.Event.OnRetryGetUsers)
                }
            )
            UserDetailContent(
                modifier = Modifier.weight(0.5f),
                uiState = uiState,
                onEvent = onEvent,
            )
        }

    }
}