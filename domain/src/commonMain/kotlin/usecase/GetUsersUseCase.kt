package usecase

import base.BaseUseCaseFlow
import model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import repository.user.UserRepository

class GetUsersUseCase(
    private val repository: UserRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCaseFlow<Unit, List<User>>(dispatcher) {

    override suspend fun build(request: Unit): Flow<List<User>> {
        return repository.getAndSaveAll()
    }
}