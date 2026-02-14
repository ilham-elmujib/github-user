package co.id.ilhamelmujib.githubuser.repository.user_repo

import co.id.ilhamelmujib.githubuser.model.User
import co.id.ilhamelmujib.githubuser.model.UserRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import source.user.UserLocalDataSource
import source.user.UserRemoteDataSource
import source.user_repo.UserRepoLocalDataSource
import source.user_repo.UserRepoRemoteDataSourceImpl

class UserRepoRepositoryImpl(
    private val remote: UserRepoRemoteDataSourceImpl,
    private val local: UserRepoLocalDataSource
): UserRepoRepository {
    override suspend fun getAndSaveAll(): Flow<List<UserRepo>> {
        return flowOf()
    }
}