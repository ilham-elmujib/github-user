package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import preferences.SharedPreferences
import preferences.SharedPreferencesImpl

val coreModule : Module = module {
    includes(dataStoreModule)
    includes(utilsModule)
    singleOf(::SharedPreferencesImpl) bind SharedPreferences::class
}