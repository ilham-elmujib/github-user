package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import preferences.SharedPreferences
import preferences.SharedPreferencesImpl

expect val dataStoreModule: Module

val coreModule : Module = module {
    includes(dataStoreModule)
    singleOf(::SharedPreferencesImpl) bind SharedPreferences::class
}