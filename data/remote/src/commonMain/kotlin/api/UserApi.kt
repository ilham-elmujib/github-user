package api

import com.skydoves.sandwich.ApiResponse
import de.jensklingenberg.ktorfit.http.GET

interface UserApi {
    @GET("v1/customer/")
    suspend fun get(): ApiResponse<String>
}