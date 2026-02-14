package database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

actual class DatabaseFactory {
    actual fun build(): AppDatabase {
        val dbFile = File(System.getProperty("java.io.tmpdir"), DATABASE_NAME)
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath,
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}