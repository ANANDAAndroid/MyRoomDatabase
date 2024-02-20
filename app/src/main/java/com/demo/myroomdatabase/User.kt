package com.demo.myroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USERDATA")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "os") val os: String,
    @ColumnInfo(name = "amount") val amount: Int,
    @ColumnInfo(name = "language") val language: String
)
