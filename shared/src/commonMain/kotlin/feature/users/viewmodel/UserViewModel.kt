package co.id.ilhamelmujib.githubuser.feature.users.viewmodel

import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import model.UiResult
import usecase.GetUsersUseCase

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : BaseViewModel<UserContract.Event, UserContract.State, UserContract.Effect>() {

    init {
        getAll()
    }

    override fun createInitialState(): UserContract.State {
        return UserContract.State(
            userResult = UiResult.Idle
        )
    }

    override fun handleEvent(event: UserContract.Event) {
        when (event) {
            UserContract.Event.OnNavigateToRepo -> {
                setEffect { UserContract.Effect.NavigateToRepo }
            }
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            setState { copy(userResult = UiResult.Loading) }
            getUsersUseCase(Unit)
                .distinctUntilChanged()
                .collect { result ->
                    result.onSuccess {
                        setState { copy(userResult = UiResult.Success(it)) }
                    }
                    result.onFailure {
                        setState { copy(userResult = UiResult.Error(it.message.orEmpty())) }
                    }
                }
        }
    }
}