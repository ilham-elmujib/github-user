package di

import database.AppDatabase
import database.DatabaseFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databaseModule: Module = module {
    single<AppDatabase> { DatabaseFactory().build() }
}