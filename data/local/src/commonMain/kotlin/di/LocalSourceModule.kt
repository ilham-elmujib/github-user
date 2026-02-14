package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import source.user.UserLocalDataSource
import source.user.UserLocalDataSourceImpl
import source.user_repo.UserRepoLocalDataSource
import source.user_repo.UserRepoLocalDataSourceImpl

val localSourceModule: Module = module {
    singleOf(::UserLocalDataSourceImpl) bind UserLocalDataSource::class
    singleOf(::UserRepoLocalDataSourceImpl) bind UserRepoLocalDataSource::class
}
