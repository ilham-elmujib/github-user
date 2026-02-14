package source.user

import entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun saveAll(users: List<UserEntity>)
    fun getAll(): Flow<List<UserEntity>>
}

