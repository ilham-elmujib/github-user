package repository.user

import model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getAll(): Flow<List<User>>
    suspend fun getByName(query: String): Flow<List<User>>
    suspend fun getDetail(login: String): Flow<User>
}

