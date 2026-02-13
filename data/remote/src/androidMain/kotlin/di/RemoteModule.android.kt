package di

import HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val httpClientModule: Module = module {
    singleOf(::HttpClientFactory)
}