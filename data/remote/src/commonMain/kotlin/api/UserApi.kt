package api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import response.UserResponse

interface UserApi {
    @GET(ApiUrl.USER)
    suspend fun getAll(): List<UserResponse>?

    @GET(ApiUrl.USER_DETAIL)
    suspend fun getDetail(
        @Path("login") login: String
    ): UserResponse?
}