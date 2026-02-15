package feature.user.screen

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import base.BaseScreen
import feature.user.viewmodel.UserContract
import feature.user.viewmodel.UserViewModel
import org.koin.compose.viewmodel.koinViewModel

class UserScreen(
    private val navigateToRepo: (login: String) -> Unit,
    private val navigateToBrowser: (url: String) -> Unit,
): BaseScreen<UserViewModel, UserContract.Event, UserContract.State, UserContract.Effect>() {

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
        snackBarHostState: SnackbarHostState
    ) {
        when (uiEffect) {
            is UserContract.Effect.NavigateToRepo -> {
                navigateToRepo(uiEffect.login)
            }

            is UserContract.Effect.NavigateToBrowser -> {
                navigateToBrowser(uiEffect.url)
            }

            is UserContract.Effect.ShowSnackBar -> {
                snackBarHostState.showSnackbar(
                    message = uiEffect.message
                )
            }

        }
    }
}