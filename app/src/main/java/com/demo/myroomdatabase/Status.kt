package com.demo.myroomdatabase

sealed class Status<out T> {
    data object Processing: Status<Nothing>()
    data class Success<out T>( val value:T): Status<T>()
    data object Failure: Status<Nothing>()
}