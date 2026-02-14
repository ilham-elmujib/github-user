package database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Room

actual class DatabaseFactory(private val context: Context) {
    actual fun build(): AppDatabase {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(DATABASE_NAME)
        println("Location: ${dbFile.absolutePath}")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        ).build()
    }
}