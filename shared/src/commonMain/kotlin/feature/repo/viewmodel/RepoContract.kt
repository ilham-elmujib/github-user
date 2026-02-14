package feature.repo.viewmodel

import model.Repo
import model.UiEffect
import model.UiEvent
import model.UiResult
import model.UiState
import model.UserRepo

sealed class RepoContract {
    sealed class Event : UiEvent {
        class OnSearchBarExpand(val expanded: Boolean) : Event()
        class OnSearchQueryChange(val searchQuery: String) : Event()
        object OnRetry : Event()
        object OnNavigateToBack : Event()
    }

    data class State(
        val login: String,
        val searchQuery: String,
        val searchBarExpanded: Boolean,
        val reposResult: UiResult<UserRepo>,
        val allRepos: List<Repo>,
    ) : UiState

    sealed class Effect : UiEffect {
        object NavigateToBack : Effect()
        class ShowSnackBar(val message: String) : Effect()
    }
}

