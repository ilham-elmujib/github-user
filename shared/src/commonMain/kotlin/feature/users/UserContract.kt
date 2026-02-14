package co.id.ilhamelmujib.githubuser.feature.users

import model.UiEffect
import model.UiEvent
import model.UiState

sealed class UserContract {
    sealed class Event : UiEvent {

    }

    data class State(
        val isLoading: Boolean = false
    ) : UiState

    sealed class Effect : UiEffect {
        data object OnBackPressed : Effect()
        data class ShowSnackBar(val message: String) : Effect()
    }
}

