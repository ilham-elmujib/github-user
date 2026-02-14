package api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import response.UserRepoResponse

interface UserRepoApi {

    @GET(Endpoints.USER_REPOSITORY)
    suspend fun getAll(
        @Path("login") login: String
    ): List<UserRepoResponse>?
}