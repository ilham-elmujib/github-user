import com.skydoves.sandwich.ktorfit.ApiResponseConverterFactory
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object NetworkConfig {
    val jsonConfig = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
        useAlternativeNames = false
        isLenient = true
        explicitNulls = true
    }

    fun createHttpClient(engine: HttpClientEngine) = HttpClient(engine) {
        expectSuccess = true
        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
        install(ContentNegotiation) {
            json(jsonConfig)
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    fun createKtorfit(client: HttpClient): Ktorfit {
        return Ktorfit.Builder()
            .httpClient(client)
            .baseUrl("BuildKonfig.BASE_URL")
            .converterFactories(ApiResponseConverterFactory.create())
            .build()
    }
}