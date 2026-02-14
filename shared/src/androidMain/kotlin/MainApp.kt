package co.id.ilhamelmujib.githubuser

import android.app.Application
import di.initKoin
import org.koin.dsl.module

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            modules(module {
                single { this@MainApp }
            })
        }
    }
}