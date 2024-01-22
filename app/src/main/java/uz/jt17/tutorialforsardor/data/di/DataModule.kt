package uz.jt17.tutorialforsardor.data.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uz.jt17.tutorialforsardor.data.local.AppDatabase

val dataModule = module {

    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = AppDatabase.APP_DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().myDao() }

}