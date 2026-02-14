package feature.repo.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import base.BaseViewModel
import feature.repo.navigation.RepoRoute
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import model.UiResult
import usecase.GetUserRepoUseCase

class RepoViewModel(
    savedStateHandle: SavedStateHandle,
    private val getUserRepoUseCase: GetUserRepoUseCase
) : BaseViewModel<RepoContract.Event, RepoContract.State, RepoContract.Effect>() {

    init {
        val repo = savedStateHandle.toRoute<RepoRoute>()
        setState { copy(login = repo.login) }
        getUserRepo(repo.login)
    }

    override fun createInitialState(): RepoContract.State {
        return RepoContract.State(
            login = "",
            reposResult = UiResult.Idle,
            allRepos = emptyList(),
            searchQuery = "",
            searchBarExpanded = false
        )
    }

    override fun handleEvent(event: RepoContract.Event) {
        when (event) {
            is RepoContract.Event.OnSearchBarExpand -> {
                setState { copy(searchBarExpanded = event.expanded) }
            }

            is RepoContract.Event.OnSearchQueryChange -> {
                val repos = uiState.value.allRepos.filter {
                    it.fullName.contains(event.searchQuery, ignoreCase = true)
                }
            }

            RepoContract.Event.OnRetry -> {
                getUserRepo(currentState.login)
            }

            RepoContract.Event.OnNavigateToBack -> {
                setEffect { RepoContract.Effect.NavigateToBack }
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
                                allRepos = it.repos
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