package co.id.ilhamelmujib.githubuser

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import org.koin.dsl.module

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            modules(
                module {
                    androidContext(this@MainApp)
                    androidLogger(Level.INFO)
                    single { this@MainApp }
                }
            )
        }
    }
}