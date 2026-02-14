package source.repo

import api.RepoApi
import response.RepoResponse

class RepoRemoteDataSourceImpl(
    private val api: RepoApi
) : RepoRemoteDataSource {
    override suspend fun getAll(login: String): List<RepoResponse>? {
        return api.getAll(login)
    }
}

