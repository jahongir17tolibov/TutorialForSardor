package uz.jt17.tutorialforsardor

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import uz.jt17.tutorialforsardor.data.di.dataModule
import uz.jt17.tutorialforsardor.domain.di.appModule
import uz.jt17.tutorialforsardor.domain.di.viewModelModule

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            dataModule,
            appModule,
            viewModelModule,
        )

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@MyApp)
            modules(modules)
        }

    }

}