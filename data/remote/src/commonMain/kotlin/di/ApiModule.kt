package di

import api.UserApi
import api.UserRepoApi
import api.createUserApi
import api.createUserRepoApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.core.module.Module
import org.koin.dsl.module

val apiModule: Module = module {
    single<UserApi> { get<Ktorfit>().createUserApi() }
    single<UserRepoApi> { get<Ktorfit>().createUserRepoApi() }
}
