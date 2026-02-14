package source.user

import api.UserApi
import response.UserResponse

class UserRemoteDataSourceImpl(
    private val api: UserApi
) : UserRemoteDataSource {
    override suspend fun getAll(): List<UserResponse> {
        api.getAll()
        return emptyList()
    }
}

