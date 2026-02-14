package feature.repo.screen

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import base.BaseScreen
import feature.repo.viewmodel.RepoContract
import feature.repo.viewmodel.RepoViewModel
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import utils.UrlHandler

class RepoScreen(
    private val navigateToBack: () -> Unit,
    private val navigateToBrowser:(String) -> Unit,
): BaseScreen<RepoViewModel, RepoContract.Event, RepoContract.State, RepoContract.Effect>() {

    @Composable
    override fun viewModel(): RepoViewModel = koinViewModel<RepoViewModel>()

    @Composable
    override fun MobileContent(
        onEvent: (RepoContract.Event) -> Unit,
        uiState: RepoContract.State,
        snackBarHostState: SnackbarHostState
    ) {
        RepoMobile(
            onEvent = onEvent,
            uiState = uiState,
            snackBarHostState = snackBarHostState
        )
    }

    @Composable
    override fun TabletContent(
        onEvent: (RepoContract.Event) -> Unit,
        uiState: RepoContract.State,
        snackBarHostState: SnackbarHostState
    ) {
        RepoTablet(
            onEvent = onEvent,
            uiState = uiState,
            snackBarHostState = snackBarHostState
        )
    }

    override suspend fun handleEffect(
        uiState: RepoContract.State,
        uiEffect: RepoContract.Effect,
        snackBarHostState: SnackbarHostState
    ) {
        when (uiEffect) {
            RepoContract.Effect.NavigateToBack -> {
                navigateToBack()
            }
            is RepoContract.Effect.NavigateToBrowser -> {
                navigateToBrowser(uiEffect.url)
            }
        }
    }
}