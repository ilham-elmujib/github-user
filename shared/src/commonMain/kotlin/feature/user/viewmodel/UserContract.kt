package feature.user.viewmodel

import model.User
import model.UiEffect
import model.UiEvent
import model.UiResult
import model.UiState
import model.UserRepo

sealed class UserContract {
    sealed class Event : UiEvent {
        class OnSearchBarExpand(val expanded: Boolean) : Event()
        class OnSearchQueryChange(val searchQuery: String) : Event()
        object OnRetryGetUsers : Event()
        class OnSelectUserItem(val login: String) : Event()
        class OnNavigateToRepo(val login: String) : Event()
        object OnRetryGetUserDetail : Event()
        class OnNavigateToBrowser(val url: String) : Event()
    }

    data class State(
        val searchQuery: String,
        val searchBarExpanded: Boolean,
        val usersResult: UiResult<List<User>>,
        val allUsers: List<User>,
        val reposResult: UiResult<UserRepo>,
    ) : UiState

    sealed class Effect : UiEffect {
        class NavigateToRepo(val login: String) : Effect()
        class NavigateToBrowser(val url: String) : Effect()
        class ShowSnackBar(val message: String) : Effect()
    }
}

