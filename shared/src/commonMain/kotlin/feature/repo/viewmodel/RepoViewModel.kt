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
import utils.UrlHandler

class RepoViewModel(
    savedStateHandle: SavedStateHandle,
    private val urlHandler: UrlHandler,
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
        )
    }

    override fun handleEvent(event: RepoContract.Event) {
        when (event) {
            RepoContract.Event.OnRetry -> {
                getUserRepo(currentState.login)
            }

            RepoContract.Event.OnNavigateToBack -> {
                setEffect { RepoContract.Effect.NavigateToBack }
            }

            is RepoContract.Event.OnNavigateToBrowser -> {
                setEffect {
                    RepoContract.Effect.NavigateToBrowser(event.url)
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