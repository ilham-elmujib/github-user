package source.user_repo

import entity.UserRepoEntity
import kotlinx.coroutines.flow.Flow

interface UserRepoLocalDataSource {
    suspend fun saveAll(userRepos: List<UserRepoEntity>)
    fun getAll(): Flow<List<UserRepoEntity>>
}

