package repository.user

import model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getAll(): Flow<List<User>>
    suspend fun getDetail(login: String): Flow<User>
}

