package com.demo.myroomdatabase

import javax.inject.Inject

class Repository @Inject constructor(val appDataBase: AppDataBase):GetDataFromSource {

    suspend fun getData() = getDataFromSource {
        appDataBase.myDao().getAll()
    }
}