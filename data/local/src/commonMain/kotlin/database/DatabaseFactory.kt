package database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun build(): AppDatabase
}