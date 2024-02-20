package com.demo.myroomdatabase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetDataFromSource  {
    suspend fun <Any>getDataFromSource( value: suspend () -> Any):Status<Any>{
        return withContext(Dispatchers.IO){
            try {
                Status.Success(value.invoke())
            }catch (e:Exception){
                println("failure :: ${e.printStackTrace()}")
                Status.Failure
            }
        }
    }
}