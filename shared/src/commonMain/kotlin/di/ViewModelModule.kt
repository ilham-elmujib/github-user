package co.id.ilhamelmujib.githubuser.di

import co.id.ilhamelmujib.githubuser.feature.users.UserViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule : Module = module {
    viewModelOf(::UserViewModel)
}

