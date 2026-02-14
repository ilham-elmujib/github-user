package usecase

import base.BaseUseCaseFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import model.UserRepo
import repository.user.UserRepository
import repository.repo.RepoRepository

class GetUserRepoUseCase(
    dispatcher: CoroutineDispatcher,
    private val userRepository: UserRepository,
    private val repoRepository: RepoRepository
) : BaseUseCaseFlow<String, UserRepo>(dispatcher) {

    override suspend fun build(request: String): Flow<UserRepo> {
        val userFlow = userRepository.getDetail(request)
        val reposFlow = repoRepository.getAll(request)

        return userFlow.zip(reposFlow) { user, repos ->
            UserRepo(
                user = user,
                repos = repos
            )
        }
    }
}