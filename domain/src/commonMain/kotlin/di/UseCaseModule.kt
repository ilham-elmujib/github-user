package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import usecase.GetUserRepoUseCase
import usecase.GetUsersByNameUseCase
import usecase.GetUsersUseCase

val useCaseModule : Module = module {
    singleOf(::GetUsersUseCase)
    singleOf(::GetUsersByNameUseCase)
    singleOf(::GetUserRepoUseCase)
}
