package feature.users.screen

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import base.BaseScreen
import co.id.ilhamelmujib.githubuser.feature.users.viewmodel.UserContract
import co.id.ilhamelmujib.githubuser.feature.users.viewmodel.UserViewModel
import navigation.RepoNavigation
import org.koin.compose.viewmodel.koinViewModel

class UserScreen: BaseScreen<UserViewModel, UserContract.Event, UserContract.State, UserContract.Effect>() {

    @Composable
    override fun viewModel(): UserViewModel = koinViewModel<UserViewModel>()

    @Composable
    override fun MobileContent(
        onEvent: (UserContract.Event) -> Unit,
        uiState: UserContract.State,
        snackBarHostState: SnackbarHostState
    ) {
        UserMobile(
            onEvent = onEvent,
            uiState = uiState,
            snackBarHostState = snackBarHostState
        )
    }

    @Composable
    override fun TabletContent(
        onEvent: (UserContract.Event) -> Unit,
        uiState: UserContract.State,
        snackBarHostState: SnackbarHostState
    ) {
        UserTablet(
            onEvent = onEvent,
            uiState = uiState,
            snackBarHostState = snackBarHostState
        )
    }

    override suspend fun handleEffect(
        uiState: UserContract.State,
        uiEffect: UserContract.Effect,
        navController: NavController,
        snackBarHostState: SnackbarHostState
    ) {
        when (uiEffect) {
            UserContract.Effect.NavigateToRepo -> {
                navController.navigate(RepoNavigation.destination)
            }

            is UserContract.Effect.ShowSnackBar -> {
                snackBarHostState.showSnackbar(
                    message = uiEffect.message
                )
            }

        }
    }
}