import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class HttpClientFactory {
    actual val engine: HttpClientEngine = Darwin.create()
}