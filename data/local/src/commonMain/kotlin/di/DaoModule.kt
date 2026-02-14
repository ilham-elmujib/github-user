package di

import database.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

val daoModule : Module = module {
    single { get<AppDatabase>().userDao() }
}