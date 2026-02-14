package source.user_repo

import dao.UserRepoDao
import entity.UserRepoEntity
import kotlinx.coroutines.flow.Flow

class UserRepoLocalDataSourceImpl(
    private val dao: UserRepoDao
) : UserRepoLocalDataSource {
    override suspend fun saveAll(userRepos: List<UserRepoEntity>) {
        dao.insertAll(userRepos)
    }

    override fun getAll(): Flow<List<UserRepoEntity>> {
        return dao.getAll()
    }
}