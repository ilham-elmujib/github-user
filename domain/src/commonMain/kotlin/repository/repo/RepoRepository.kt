package repository.repo

import model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun getAll(login: String): Flow<List<Repo>>
}

