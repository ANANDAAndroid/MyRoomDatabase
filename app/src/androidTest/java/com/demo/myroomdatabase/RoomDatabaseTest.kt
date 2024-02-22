package com.demo.myroomdatabase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {

    @get:Rule
    val instantExecutorRule= InstantTaskExecutorRule()

    lateinit var appDataBase: AppDataBase
    lateinit var myDao: MyDao

    @Before
    fun setup() {
        appDataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDataBase::class.java
        ).allowMainThreadQueries().build()
        myDao=appDataBase.myDao()

    }
    @Test
     fun testDatabase()= runBlocking{

            val data= User(0,"ananda","Android",20,"english")
            myDao.insertAll(arrayListOf(data))
         val abc=   myDao.getAll()
        Assert.assertEquals(1,abc.size)
        Assert.assertEquals("Android",abc[0].os)
    }
    @Test
    fun testDatabase2()= runBlocking{
            val data= User(0,"ananda","Android",20,"english")
            myDao.insertAll(arrayListOf(data))
           val abc= myDao.getAll()
        Assert.assertEquals("Android",abc[0].os)
    }

    @After
    fun tearDown() {

        appDataBase.close()
    }
}