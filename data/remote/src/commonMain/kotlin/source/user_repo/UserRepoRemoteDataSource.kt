package source.user_repo

import response.UserRepoResponse

interface UserRepoRemoteDataSource {
    suspend fun getAll(): List<UserRepoResponse>
}

