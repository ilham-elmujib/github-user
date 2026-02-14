package source.repo

import dao.RepoDao
import entity.RepoEntity
import kotlinx.coroutines.flow.Flow

class RepoLocalDataSourceImpl(
    private val dao: RepoDao
) : RepoLocalDataSource {
    override suspend fun saveAll(repos: List<RepoEntity>) {
        dao.insertAll(repos)
    }

    override fun getAll(): Flow<List<RepoEntity>> {
        return dao.getAll()
    }
}