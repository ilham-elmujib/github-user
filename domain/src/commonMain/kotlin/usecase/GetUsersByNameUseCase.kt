package usecase

import base.BaseUseCaseFlow
import model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import repository.user.UserRepository

class GetUsersByNameUseCase(
    dispatcher: CoroutineDispatcher,
    private val userRepository: UserRepository
) : BaseUseCaseFlow<String, List<User>>(dispatcher) {

    override suspend fun build(request: String): Flow<List<User>> {
        return userRepository.getByName(request)
    }
}