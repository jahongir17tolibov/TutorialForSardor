package uz.jt17.tutorialforsardor.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.jt17.tutorialforsardor.data.entity.CurrentDataEntity

@Database(entities = [CurrentDataEntity::class], version = AppDatabase.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val APP_DATABASE_NAME: String = "my_database.db"
        const val DB_VERSION = 1
    }

    abstract fun myDao(): MyDao

}