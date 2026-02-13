package co.id.ilhamelmujib.githubuser.di

import di.dataStoreModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            dataStoreModule,
            domainModule,
        )
    }

