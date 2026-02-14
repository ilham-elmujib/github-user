package di

import HttpClientFactory
import api.UserApi
import api.UserRepoApi
import api.createUserApi
import api.createUserRepoApi
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import source.user.UserRemoteDataSource
import source.user.UserRemoteDataSourceImpl
import source.user_repo.UserRepoRemoteDataSource
import source.user_repo.UserRepoRemoteDataSourceImpl

expect val httpClientModule : Module

private val networkModule: Module = module {
    single<HttpClient> { NetworkConfig.createHttpClient(get<HttpClientFactory>().engine) }
    single<Ktorfit> { NetworkConfig.createKtorfit(get()) }
}

private val apiModule: Module = module {
    single<UserApi> { get<Ktorfit>().createUserApi() }
    single<UserRepoApi> { get<Ktorfit>().createUserRepoApi() }
}

private val dataSourceModule : Module = module {
    singleOf(::UserRemoteDataSourceImpl) bind UserRemoteDataSource::class
    singleOf(::UserRepoRemoteDataSourceImpl) bind UserRepoRemoteDataSource::class
}

val remoteModule: Module = module {
    includes(httpClientModule)
    includes(networkModule)
    includes(apiModule)
    includes(dataSourceModule)
}


