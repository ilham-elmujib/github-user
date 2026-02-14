package feature.users.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.users.component.UserList
import feature.users.component.UserTopBar
import co.id.ilhamelmujib.githubuser.feature.users.viewmodel.UserContract

@Composable
fun UserTablet(
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
//        UserList(
//            modifier = Modifier.padding(it),
//            users = uiState.users,
//            onItemClick = {
//                onEvent(UserContract.Event.OnNavigateToRepo)
//            }
//        )
    }
}