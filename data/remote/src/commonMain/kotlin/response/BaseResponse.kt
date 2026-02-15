package response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("total_count")
    val totalCount: Int? = null,
    
    @SerialName("incomplete_results")
    val incompleteResults: Boolean,
    
    @SerialName("items")
    val items: List<T>? = null
)