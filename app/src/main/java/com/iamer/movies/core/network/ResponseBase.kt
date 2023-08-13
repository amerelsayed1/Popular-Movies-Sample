package com.iamer.movies.core.network

import com.iamer.movies.core.data.network.ErrorResponse

data class ResponseBase<T> (
    val isRequestSuccess: Boolean=false,
    val responseBody: T?,
    val errorResponse: ErrorResponse = ErrorResponse()
)