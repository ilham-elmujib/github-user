package di

import HttpClientFactory
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single<HttpClient> { NetworkConfig.createHttpClient(get<HttpClientFactory>().engine) }
    single<Ktorfit> { NetworkConfig.createKtorfit(get()) }
}
