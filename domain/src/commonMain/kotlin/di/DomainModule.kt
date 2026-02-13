package co.id.ilhamelmujib.githubuser.di

import di.localModule
import di.remoteModule
import org.koin.core.module.Module
import org.koin.dsl.module

val domainModule: Module = module {
    includes(localModule)
    includes(remoteModule)
}