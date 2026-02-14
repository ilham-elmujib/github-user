package co.id.ilhamelmujib.githubuser.di

import co.id.ilhamelmujib.githubuser.repository.user.UserRepository
import co.id.ilhamelmujib.githubuser.repository.user.UserRepositoryImpl
import co.id.ilhamelmujib.githubuser.repository.user_repo.UserRepoRepository
import co.id.ilhamelmujib.githubuser.repository.user_repo.UserRepoRepositoryImpl
import di.localModule
import di.remoteModule
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

private val repositoryModule : Module = module {
    singleOf(::UserRepositoryImpl) bind UserRepository::class
    singleOf(::UserRepoRepositoryImpl) bind UserRepoRepository::class

}
val domainModule: Module = module {
    includes(localModule)
    includes(remoteModule)
    includes(repositoryModule)
}