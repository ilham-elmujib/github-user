package source.user

import response.UserResponse

interface UserRemoteDataSource {
    suspend fun getAll(): List<UserResponse>
}

