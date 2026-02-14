package repository.user

import mapper.toDomains
import mapper.toEntities
import model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import mapper.toDomain
import mapper.toEntity
import source.user.UserLocalDataSource
import source.user.UserRemoteDataSource

class UserRepositoryImpl(
    private val remote: UserRemoteDataSource,
    private val local: UserLocalDataSource
) : UserRepository {

    override suspend fun getAll(): Flow<List<User>> = flow {
        remote.getAll()?.toEntities()?.also { entities ->
            local.saveAll(entities)
        }
        local.getAll()
            .map { it.toDomains() }
            .also { emitAll(it) }
    }

    override suspend fun getDetail(login: String): Flow<User> = flow {
        remote.getDetail(login)?.toEntity()?.also { entity ->
            local.update(entity)
        }
        local.getDetail(login)
            .map { it.toDomain() }
            .also { emitAll(it) }
    }
}