package di

import HttpClientFactory
import api.UserApi
import api.createUserApi
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

expect val httpClientModule : Module

private val networkModule: Module = module {
    single<HttpClient> { NetworkConfig.createHttpClient(get<HttpClientFactory>().engine) }
    single<Ktorfit> { NetworkConfig.createKtorfit(get()) }
}

private val apiModule: Module = module {
    single<UserApi> { get<Ktorfit>().createUserApi() }
}

val remoteModule: Module = module {
    includes(httpClientModule)
    includes(networkModule)
    includes(apiModule)
}


