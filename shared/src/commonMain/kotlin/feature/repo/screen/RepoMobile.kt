package feature.repo.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.id.ilhamelmujib.githubuser.feature.repo.component.RepoContent
import co.id.ilhamelmujib.githubuser.feature.repo.component.RepoTopBar
import feature.repo.viewmodel.RepoContract

@Composable
fun RepoMobile(
    modifier: Modifier = Modifier,
    onEvent: (RepoContract.Event) -> Unit,
    uiState: RepoContract.State,
    snackBarHostState: SnackbarHostState,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            RepoTopBar(
                onBackPressed = {
                    onEvent(RepoContract.Event.OnNavigateToBack)
                }
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        RepoContent(
            modifier = modifier.padding(it),
            onEvent = onEvent,
            uiState = uiState
        )
    }
}