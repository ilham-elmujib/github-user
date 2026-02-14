package feature.user.viewmodel

import model.User
import model.UiEffect
import model.UiEvent
import model.UiResult
import model.UiState

sealed class UserContract {
    sealed class Event : UiEvent {
        class OnSearchBarExpand(val expanded: Boolean) : Event()
        class OnSearchQueryChange(val searchQuery: String) : Event()
        object OnRetry : Event()
        class OnNavigateToRepo(val login: String) : Event()
    }

    data class State(
        val searchQuery: String,
        val searchBarExpanded: Boolean,
        val usersResult: UiResult<List<User>>,
        val allUsers: List<User>
    ) : UiState

    sealed class Effect : UiEffect {
        class NavigateToRepo(val login: String) : Effect()
        class ShowSnackBar(val message: String) : Effect()
    }
}

