package source.repo

import response.RepoResponse

interface RepoRemoteDataSource {
    suspend fun getAll(login: String): List<RepoResponse>?
}

