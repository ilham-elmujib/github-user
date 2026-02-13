package di

import org.koin.core.module.Module
import org.koin.dsl.module
import preferences.DataStoreFactory

actual val dataStoreModule: Module = module {
    single { DataStoreFactory().create() }
}