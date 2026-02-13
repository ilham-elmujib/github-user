package di

import PlatformHttpClientEngine
import api.UserApi
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

expect val httpClientModule : Module

private val apiModule: Module = module {
    single<HttpClient> { ApiConfigFactory.createHttpClient(get<PlatformHttpClientEngine>().engine) }
    single<Ktorfit> { ApiConfigFactory.createKtorfit(get()) }
    single<UserApi> { ApiConfigFactory.getUserApi(get()) }
}

val remoteModule: Module = module {
    includes(httpClientModule)
    includes(apiModule)
}


