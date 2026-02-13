import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.js.Js

actual class PlatformHttpClientEngine {
    actual val engine: HttpClientEngine = Js.create()
}