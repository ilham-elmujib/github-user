import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class PlatformHttpClientEngine {
    actual val engine: HttpClientEngine = Darwin.create()
}