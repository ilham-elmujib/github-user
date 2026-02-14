package di

import api.UserApi
import api.RepoApi
import api.createUserApi
import api.createRepoApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.core.module.Module
import org.koin.dsl.module

val apiModule: Module = module {
    single<UserApi> { get<Ktorfit>().createUserApi() }
    single<RepoApi> { get<Ktorfit>().createRepoApi() }
}
