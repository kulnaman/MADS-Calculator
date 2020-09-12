package com.example.mads_calculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CalculatorEntity::class], version = 1, exportSchema = false)
public abstract class CalculatorRoomDatabase : RoomDatabase() {

    abstract fun calculatorDao(): CalculatorDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CalculatorRoomDatabase? = null

        fun getDatabase(context: Context): CalculatorRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalculatorRoomDatabase::class.java,
                    "calculator_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}