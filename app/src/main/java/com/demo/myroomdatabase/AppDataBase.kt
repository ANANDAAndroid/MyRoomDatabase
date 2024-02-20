package com.demo.myroomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter

@Database(entities = [User::class,Student::class], version = 2, exportSchema = false)
abstract class AppDataBase :RoomDatabase() {
    abstract fun myDao():MyDao
}