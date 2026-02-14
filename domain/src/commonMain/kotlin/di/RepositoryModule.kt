package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import repository.user.UserRepository
import repository.user.UserRepositoryImpl
import repository.user_repo.UserRepoRepository
import repository.user_repo.UserRepoRepositoryImpl

val repositoryModule : Module = module {
    singleOf(::UserRepositoryImpl) bind UserRepository::class
    singleOf(::UserRepoRepositoryImpl) bind UserRepoRepository::class
}