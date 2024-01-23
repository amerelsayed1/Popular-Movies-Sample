package com.iamer.movies_app_compose.core.network

import com.iamer.movies.core.network.ErrorResponse


data class ResponseBase<T> (
    val isRequestSuccess: Boolean=false,
    val responseBody: T?,
    val errorResponse: ErrorResponse = ErrorResponse()
)