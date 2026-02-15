package api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import response.BaseResponse
import response.UserResponse

interface UserApi {
    @GET(ApiUrl.USER)
    suspend fun getAll(): List<UserResponse>?

    @GET(ApiUrl.USER_SEARCH)
    suspend fun getByName(
        @Query("q") query: String
    ): BaseResponse<UserResponse>?

    @GET(ApiUrl.USER_DETAIL)
    suspend fun getDetail(
        @Path("login") login: String
    ): UserResponse?
}