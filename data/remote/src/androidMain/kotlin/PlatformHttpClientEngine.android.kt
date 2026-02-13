import io.ktor.client.engine.HttpClientEngine
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.logging.HttpLoggingInterceptor

actual class PlatformHttpClientEngine(
    private val context: Context,
) {

    private val chuckerCollector by lazy {
        ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.FOREVER
        )
    }

    private val chuckerInterceptor by lazy {
        ChuckerInterceptor.Builder(context)
            .collector(chuckerCollector)
            .maxContentLength(250_000L)
            .alwaysReadResponseBody(true)
            .createShortcut(true)
            .build()
    }

    private val loggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    actual val engine: HttpClientEngine
        get() = OkHttp.create {
            addInterceptor(chuckerInterceptor)
            addInterceptor(loggingInterceptor)
        }
}