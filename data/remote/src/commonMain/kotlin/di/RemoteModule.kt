package di

import org.koin.core.module.Module
import org.koin.dsl.module
val remoteModule: Module = module {
    includes(httpClientModule)
    includes(networkModule)
    includes(apiModule)
    includes(remoteSourceModule)
}


