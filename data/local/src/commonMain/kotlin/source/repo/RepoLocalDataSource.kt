package source.repo

import entity.RepoEntity
import kotlinx.coroutines.flow.Flow

interface RepoLocalDataSource {
    suspend fun saveAll(repos: List<RepoEntity>)
    fun getByUserLogin(login: String): Flow<List<RepoEntity>>
}

