package feature.users.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.id.ilhamelmujib.githubuser.feature.users.component.UserContent
import feature.users.component.UserSearchBar
import feature.users.viewmodel.UserContract

@Composable
fun UserMobile(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State,
    snackBarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            UserSearchBar(
                onEvent = onEvent,
                uiState = uiState
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        UserContent(
            modifier = Modifier.padding(it),
            onEvent = onEvent,
            uiState = uiState
        )

    }
}