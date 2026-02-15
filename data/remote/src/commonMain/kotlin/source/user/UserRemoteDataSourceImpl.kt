package source.user

import api.UserApi
import response.BaseResponse
import response.UserResponse

class UserRemoteDataSourceImpl(
    private val api: UserApi
) : UserRemoteDataSource {

    override suspend fun getAll(): List<UserResponse>? {
        return api.getAll()
    }

    override suspend fun getByName(query: String): BaseResponse<UserResponse>? {
        return api.getByName(query)
    }


    override suspend fun getDetail(login: String): UserResponse? {
        return api.getDetail(login)
    }

}

