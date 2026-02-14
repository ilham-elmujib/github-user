package feature.repo.viewmodel

import model.UiEffect
import model.UiEvent
import model.UiResult
import model.UiState
import model.UserRepo

sealed class RepoContract {
    sealed class Event : UiEvent {
        object OnRetry : Event()
        object OnNavigateToBack : Event()
        class OnNavigateToBrowser(val url: String) : Event()
    }

    data class State(
        val login: String,
        val reposResult: UiResult<UserRepo>,
    ) : UiState

    sealed class Effect : UiEffect {
        object NavigateToBack : Effect()
        class NavigateToBrowser(val url: String) : Effect()
    }
}

