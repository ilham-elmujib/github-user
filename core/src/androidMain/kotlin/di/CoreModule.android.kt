package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import preferences.DataStoreFactory
import preferences.SharedPreferences
import preferences.SharedPreferencesImp

actual val coreModule: Module = module {
    single { DataStoreFactory(get()).create() }
    singleOf(::SharedPreferencesImp) bind SharedPreferences::class
}