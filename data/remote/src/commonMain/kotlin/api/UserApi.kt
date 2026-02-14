package api

import de.jensklingenberg.ktorfit.http.GET
import response.UserResponse

interface UserApi {
    @GET(Endpoints.USER)
    suspend fun getAll(): List<UserResponse>?
}