package com.demo.myroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "STUDENT")
data class Student(
   @PrimaryKey(autoGenerate = true) val id:Int=0,
   @ColumnInfo(name = "name") val name:String,
   @ColumnInfo(name = "rollNumber") val rollNumber:Int?)
