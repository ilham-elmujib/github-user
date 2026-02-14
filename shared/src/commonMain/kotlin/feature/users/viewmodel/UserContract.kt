package feature.users.viewmodel

import model.User
import model.UiEffect
import model.UiEvent
import model.UiResult
import model.UiState

sealed class UserContract {
    sealed class Event : UiEvent {
        class OnSearchUser(val searchText: String) : Event()
        object OnNavigateToRepo : Event()
    }

    data class State(
        val userResult: UiResult<List<User>>,
        val allUsers: List<User>
    ) : UiState

    sealed class Effect : UiEffect {
        object NavigateToRepo : Effect()
        class ShowSnackBar(val message: String) : Effect()
    }
}

