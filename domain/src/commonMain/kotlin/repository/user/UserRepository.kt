package co.id.ilhamelmujib.githubuser.repository.user

import co.id.ilhamelmujib.githubuser.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getAndSaveAll(): Flow<List<User>>
}

