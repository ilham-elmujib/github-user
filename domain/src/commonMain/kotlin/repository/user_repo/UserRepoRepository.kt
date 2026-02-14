package repository.user_repo

import model.UserRepo
import kotlinx.coroutines.flow.Flow

interface UserRepoRepository {
    suspend fun getAndSaveAll(): Flow<List<UserRepo>>
}

