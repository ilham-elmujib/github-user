package source.user

import response.UserResponse

interface UserRemoteDataSource {
    suspend fun getAll(): List<UserResponse>?
    suspend fun getDetail(login: String): UserResponse?
}

