package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import source.user.UserRemoteDataSource
import source.user.UserRemoteDataSourceImpl
import source.repo.RepoRemoteDataSource
import source.repo.RepoRemoteDataSourceImpl

val remoteSourceModule : Module = module {
    singleOf(::UserRemoteDataSourceImpl) bind UserRemoteDataSource::class
    singleOf(::RepoRemoteDataSourceImpl) bind RepoRemoteDataSource::class
}