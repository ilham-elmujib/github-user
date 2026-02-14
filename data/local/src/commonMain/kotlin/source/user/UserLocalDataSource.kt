package source.user

import entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun saveAll(users: List<UserEntity>)
    suspend fun update(user: UserEntity)
    fun getAll(): Flow<List<UserEntity>>
    suspend fun getDetail(login: String): Flow<UserEntity>
}

