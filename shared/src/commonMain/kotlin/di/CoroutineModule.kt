package di

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module

val coroutinesModule = module {
    single { Dispatchers.Default }
    single { Dispatchers.IO }
    single { Dispatchers.Main }
}