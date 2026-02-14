package repository.user_repo

import model.UserRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
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