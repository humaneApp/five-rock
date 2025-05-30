package com.hifeelingsapp.hifeelings.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hifeelingsapp.hifeelings.data.local.entities.LetterEntity

@Database(entities = [LetterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun letterDao(): LetterDao
    companion object {
        // Volatile annotation ensures that writes to this field are immediately
        // made visible to other threads.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // If the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "hifeelings_database" // Choose a name for your database file
                )
                    // Add any migrations if necessary, or fallbackToDestructiveMigration
                    // .fallbackToDestructiveMigration() // For development, if you change schema and don't want to write migrations
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
