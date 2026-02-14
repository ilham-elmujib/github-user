package di

import feature.user.viewmodel.UserViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule : Module = module {
    viewModelOf(::UserViewModel)
}

