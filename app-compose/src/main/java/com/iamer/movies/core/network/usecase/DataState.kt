package com.iamer.movies.core.network.usecase

sealed class DataState<out R> {
    class Success<out T>(val response: T) : DataState<T>()
    class Failure(val message: String="",val code:Int=0) : DataState<Nothing>()
    object Loading : DataState<Nothing>()

}