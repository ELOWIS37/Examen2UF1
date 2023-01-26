package com.elowis.examen2uf1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elowis.examen2uf1.model.Cataleg

@Database(
    entities = [Cataleg::class],
    version = 1,
    exportSchema = false
)

abstract class CatalegDatabase : RoomDatabase() {

    abstract fun CatalegDao(): CatalegDao

    companion object {

        @Volatile
        private var INSTANCE: CatalegDatabase? = null

        fun getDatabase(context: Context): CatalegDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): CatalegDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CatalegDatabase::class.java,
                "motor_database"
            )
                .build()
        }
    }
}