package com.iamer.movies.core.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iamer.movies.core.data.network.ErrorResponse
import com.iamer.movies.core.network.usecase.DataState
import retrofit2.Call

/**
 * Created by Amer Elsayed.
 *2/23/2022
 *dev.amer.elsayed@gmail.com
 */
object RequestHelper {

    fun <T> request(
        call: Call<T>,
        default: T
    ): DataState<T> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> DataState.Success((response.body() ?: default))
                false -> {
                    val type = object : TypeToken<ErrorResponse>() {}.type
                    val errorResponse: ErrorResponse =
                        Gson().fromJson(response.errorBody()?.charStream(), type)
                    DataState.Failure(
                        message = errorResponse.message,
                        code = response.code()
                    )
                }
            }
        } catch (exception: Throwable) {
            DataState.Failure(
                message = exception.message ?: ""
            )
        }
    }

}