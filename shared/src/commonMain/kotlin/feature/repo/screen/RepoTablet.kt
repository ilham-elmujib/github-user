package feature.repo.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.id.ilhamelmujib.githubuser.feature.repo.component.RepoContent
import feature.repo.component.RepoTopBar
import feature.repo.viewmodel.RepoContract

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoTablet(
    modifier: Modifier = Modifier,
    onEvent: (RepoContract.Event) -> Unit,
    uiState: RepoContract.State,
    snackBarHostState: SnackbarHostState,
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = modifier,
        topBar = {
            RepoTopBar(
                title = uiState.login,
                scrollBehavior = scrollBehavior,
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