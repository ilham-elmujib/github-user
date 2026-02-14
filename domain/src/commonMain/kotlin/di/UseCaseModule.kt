package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import usecase.GetUsersUseCase

val useCaseModule : Module = module {
    factoryOf(::GetUsersUseCase)
}
