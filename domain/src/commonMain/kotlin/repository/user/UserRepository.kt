package repository.user

import model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getAndSaveAll(): Flow<List<User>>
}

