package feature.repo.screen

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import feature.repo.viewmodel.RepoContract

@Composable
fun RepoTablet(
    modifier: Modifier = Modifier,
    onEvent: (RepoContract.Event) -> Unit,
    uiState: RepoContract.State,
    snackBarHostState: SnackbarHostState,
) {

}