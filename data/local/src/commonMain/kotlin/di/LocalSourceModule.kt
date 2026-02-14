package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import source.user.UserLocalDataSource
import source.user.UserLocalDataSourceImpl
import source.repo.RepoLocalDataSource
import source.repo.RepoLocalDataSourceImpl

val localSourceModule: Module = module {
    singleOf(::UserLocalDataSourceImpl) bind UserLocalDataSource::class
    singleOf(::RepoLocalDataSourceImpl) bind RepoLocalDataSource::class
}
