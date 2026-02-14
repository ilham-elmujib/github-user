package di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import utils.UrlHandler

actual val utilsModule: Module = module {
    singleOf(::UrlHandler)
}