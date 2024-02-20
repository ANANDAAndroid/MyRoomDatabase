package com.demo.myroomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao {

    @Query("select * from USERDATA")
    suspend fun getAll():List<User>

    @Insert(entity = User::class)
     fun insertAll( users: ArrayList<User>)

    @Query("update USERDATA set  name='Anupam' where name= :name ")
    fun update( name :String)

    @Insert(entity = Student::class)
    fun insertAllStudent(users: Array<Student>)

    @Delete
    fun delete(user: User)

}