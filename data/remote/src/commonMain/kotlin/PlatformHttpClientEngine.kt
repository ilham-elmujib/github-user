import io.ktor.client.engine.HttpClientEngine

expect class PlatformHttpClientEngine {
    val engine: HttpClientEngine
}