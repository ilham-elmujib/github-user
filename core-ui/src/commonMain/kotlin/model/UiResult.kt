package model

sealed interface UiResult<out T> {
    data class Success<T>(val data: T) : UiResult<T>
    data class Error(val message: String? = null) : UiResult<Nothing>
    data object Loading : UiResult<Nothing>
    data object Idle : UiResult<Nothing>
}