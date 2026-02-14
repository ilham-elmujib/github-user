package co.id.ilhamelmujib.githubuser.repository.user

import co.id.ilhamelmujib.githubuser.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import source.user.UserLocalDataSource
import source.user.UserRemoteDataSource

class UserRepositoryImpl(
    private val remote: UserRemoteDataSource,
    private val local: UserLocalDataSource
): UserRepository {
    override suspend fun getAndSaveAll(): Flow<List<User>> {
        return flowOf()
    }
}