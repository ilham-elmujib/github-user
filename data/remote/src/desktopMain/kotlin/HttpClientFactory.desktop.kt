import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO

actual class HttpClientFactory {
    actual val engine: HttpClientEngine = CIO.create()
}