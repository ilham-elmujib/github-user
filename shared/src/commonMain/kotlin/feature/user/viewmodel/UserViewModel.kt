package feature.user.viewmodel

import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import model.UiResult
import usecase.GetUserRepoUseCase
import usecase.GetUsersUseCase

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val getUserRepoUseCase: GetUserRepoUseCase
) : BaseViewModel<UserContract.Event, UserContract.State, UserContract.Effect>() {

    init {
        getUsers()
    }

    override fun createInitialState(): UserContract.State {
        return UserContract.State(
            searchQuery = "",
            searchBarExpanded = false,
            usersResult = UiResult.Idle,
            allUsers = emptyList(),
            reposResult = UiResult.Idle,
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
                setState {
                    copy(
                        searchQuery = event.searchQuery,
                        usersResult = UiResult.Success(users)
                    )
                }
            }

            UserContract.Event.OnRetryGetUsers -> {
                getUsers()
            }

            is UserContract.Event.OnSelectUserItem -> {
                val users = uiState.value.allUsers.map {
                    if (it.login == event.login) {
                        it.copy(isSelected = true)
                    } else {
                        it.copy(isSelected = false)
                    }
                }
                setState {
                    copy(usersResult = UiResult.Success(users))
                }
                getUserRepo(login = event.login)
            }

            is UserContract.Event.OnNavigateToRepo -> {
                setEffect { UserContract.Effect.NavigateToRepo(event.login) }
            }

            UserContract.Event.OnRetryGetUserDetail -> {
                uiState.value.allUsers.find { it.isSelected }?.let {
                    getUserRepo(login = it.login)
                }
            }

            is UserContract.Event.OnNavigateToBrowser -> {
                setEffect { UserContract.Effect.NavigateToBrowser(event.url) }
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

    private fun getUserRepo(login: String) {
        viewModelScope.launch {
            setState { copy(reposResult = UiResult.Loading) }
            getUserRepoUseCase
                .invoke(login)
                .distinctUntilChanged()
                .collect { result ->
                    result.onSuccess {
                        setState {
                            copy(
                                reposResult = UiResult.Success(it),
                            )
                        }
                    }
                    result.onFailure {
                        setState { copy(reposResult = UiResult.Error(it.message.orEmpty())) }
                    }
                }
        }
    }
}