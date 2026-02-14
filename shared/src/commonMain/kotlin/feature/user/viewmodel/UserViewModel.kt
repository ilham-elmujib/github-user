package feature.user.viewmodel

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
        getUsers()
    }

    override fun createInitialState(): UserContract.State {
        return UserContract.State(
            usersResult = UiResult.Idle,
            allUsers = emptyList(),
            searchQuery = "",
            searchBarExpanded = false
        )
    }

    override fun handleEvent(event: UserContract.Event) {
        when (event) {
            is UserContract.Event.OnSearchBarExpand -> {
                setState { copy(searchBarExpanded = event.expanded) }
            }

            is UserContract.Event.OnSearchQueryChange -> {
                val users = uiState.value.allUsers.filter {
                    it.login.contains(event.searchQuery, ignoreCase = true)
                }
                setState { copy(searchQuery = event.searchQuery, usersResult = UiResult.Success(users)) }
            }

            UserContract.Event.OnRetry -> {
                getUsers()
            }

            is UserContract.Event.OnNavigateToRepo -> {
                setEffect { UserContract.Effect.NavigateToRepo(event.login) }
            }

        }
    }

    private fun getUsers() {
        viewModelScope.launch {
            setState { copy(usersResult = UiResult.Loading) }
            getUsersUseCase
                .invoke(Unit)
                .distinctUntilChanged()
                .collect { result ->
                    result.onSuccess {
                        setState {
                            copy(
                                usersResult = UiResult.Success(it),
                                allUsers = it
                            )
                        }
                    }
                    result.onFailure {
                        setState { copy(usersResult = UiResult.Error(it.message.orEmpty())) }
                    }
                }
        }
    }
}