import io.ktor.client.engine.HttpClientEngine

expect class HttpClientFactory {
    val engine: HttpClientEngine
}