package di

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val coroutinesModule = module {
    factory { Dispatchers.Default }
    factory { Dispatchers.IO }
    factory { Dispatchers.Main }
}