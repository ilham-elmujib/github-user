package co.id.ilhamelmujib.githubuser.repository.user_repo

import co.id.ilhamelmujib.githubuser.model.User
import co.id.ilhamelmujib.githubuser.model.UserRepo
import kotlinx.coroutines.flow.Flow

interface UserRepoRepository {
    suspend fun getAndSaveAll(): Flow<List<UserRepo>>
}

