package di

import org.koin.core.module.Module
import org.koin.dsl.module

val localModule: Module = module {
    includes(databaseModule)
    includes(daoModule)
    includes(localSourceModule)
}