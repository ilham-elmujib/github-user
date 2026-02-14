package feature.user.screen

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.user.viewmodel.UserContract

@Composable
fun UserTablet(
    modifier: Modifier = Modifier,
    onEvent: (UserContract.Event) -> Unit,
    uiState: UserContract.State,
    snackBarHostState: SnackbarHostState,
) {
//    val searchState = remember { TextFieldState() }
//
//    Scaffold(
//        modifier = modifier,
//        topBar = { UserTopBar(searchState) },
//        snackbarHost = { SnackbarHost(snackBarHostState) }
//    ) {
//        UserList(
//            modifier = Modifier.padding(it),
//            users = uiState.users,
//            onItemClick = {
//                onEvent(UserContract.Event.OnNavigateToRepo)
//            }
//        )
//    }
}