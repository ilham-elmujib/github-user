package repository.repo

import model.Repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import mapper.toDomains
import mapper.toEntities
import source.repo.RepoLocalDataSource
import source.repo.RepoRemoteDataSource
import source.repo.RepoRemoteDataSourceImpl

class RepoRepositoryImpl(
    private val remote: RepoRemoteDataSource,
    private val local: RepoLocalDataSource
) : RepoRepository {

    override suspend fun getAll(login: String): Flow<List<Repo>> = flow {
        remote.getAll(login)?.toEntities()?.also { entities ->
            local.saveAll(entities)
        }
        local.getByUserLogin(login)
            .map { it.toDomains() }
            .also { emitAll(it) }
    }
}