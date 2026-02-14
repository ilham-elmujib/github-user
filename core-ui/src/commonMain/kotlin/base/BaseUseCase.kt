package base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseUseCase<IN, OUT>(
    private val dispatcher: CoroutineDispatcher,
) {
    suspend operator fun invoke(body: IN): Result<OUT> = withContext(dispatcher) {
        try {
            val result = block(body)
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    abstract suspend fun block(request: IN): OUT
}