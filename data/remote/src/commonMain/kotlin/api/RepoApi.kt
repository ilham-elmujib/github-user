package api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import response.RepoResponse

interface RepoApi {

    @GET(ApiUrl.USER_REPOSITORY)
    suspend fun getAll(
        @Path("login") login: String
    ): List<RepoResponse>?
}