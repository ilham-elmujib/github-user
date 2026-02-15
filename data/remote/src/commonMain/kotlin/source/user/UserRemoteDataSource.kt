package source.user

import response.BaseResponse
import response.UserResponse

interface UserRemoteDataSource {
    suspend fun getAll(): List<UserResponse>?
    suspend fun getByName(query: String): BaseResponse<UserResponse>?
    suspend fun getDetail(login: String): UserResponse?
}

