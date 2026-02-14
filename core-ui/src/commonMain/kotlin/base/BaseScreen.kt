package base

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import component.template.ResponsiveContent
import kotlinx.coroutines.flow.collectLatest
import model.UiEffect
import model.UiEvent
import model.UiState

abstract class BaseScreen<VM : BaseViewModel<Event, State, Effect>, Event : UiEvent, State : UiState, Effect : UiEffect> {
    @Composable
    protected abstract fun viewModel(): VM

    @Composable
    open fun Content() {
        val viewModel = viewModel()

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.effect
        val onEvent = viewModel::onEvent
        val snackBarHostState = remember { SnackbarHostState() }

        LaunchedEffect(Unit) {
            onInitData(
                onEvent = onEvent
            )
        }

        LaunchedEffect(Unit) {
            uiEffect.collectLatest { uiEffect ->
                handleEffect(
                    uiState = uiState,
                    uiEffect = uiEffect,
                    snackBarHostState = snackBarHostState
                )
            }
        }

        ResponsiveContent(
            tablet = {
                TabletContent(
                    onEvent = onEvent,
                    uiState = uiState,
                    snackBarHostState = snackBarHostState
                )
            },
            mobile = {
                MobileContent(
                    onEvent = onEvent,
                    uiState = uiState,
                    snackBarHostState = snackBarHostState
                )
            }
        )

        DialogContent(
            onEvent = onEvent,
            uiState = uiState,
        )
    }

    @Composable
    protected abstract fun MobileContent(
        onEvent: (Event) -> Unit,
        uiState: State,
        snackBarHostState: SnackbarHostState
    )

    @Composable
    protected abstract fun TabletContent(
        onEvent: (Event) -> Unit,
        uiState: State,
        snackBarHostState: SnackbarHostState
    )

    @Composable
    protected open fun DialogContent(
        onEvent: (Event) -> Unit,
        uiState: State,
    ) = Unit

    protected open suspend fun onInitData(
        onEvent: (Event) -> Unit,
    ) = Unit

    protected open suspend fun handleEffect(
        uiState: State,
        uiEffect: Effect,
        snackBarHostState: SnackbarHostState
    ) = Unit
}