package di

import org.koin.core.module.Module
import org.koin.dsl.module

val domainModule: Module = module {
    includes(localModule)
    includes(remoteModule)
    includes(repositoryModule)
    includes(useCaseModule)
}