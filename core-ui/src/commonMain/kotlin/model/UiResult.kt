package model

sealed interface UiResult<out T> {
    data object Loading : UiResult<Nothing>
    data class Success<T>(val data: T) : UiResult<T>
    data class Error(val message: String) : UiResult<Nothing>
    data object Idle : UiResult<Nothing>
}