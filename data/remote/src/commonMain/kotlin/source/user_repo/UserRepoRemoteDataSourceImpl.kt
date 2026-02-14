package source.user_repo

import api.UserRepoApi
import response.UserRepoResponse

class UserRepoRemoteDataSourceImpl(
    private val api: UserRepoApi
) : UserRepoRemoteDataSource {
    override suspend fun getAll(): List<UserRepoResponse> {
        api.getAll("")
        return emptyList()
    }
}

