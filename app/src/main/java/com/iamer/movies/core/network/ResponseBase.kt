package com.iamer.movies.core.network


data class ResponseBase<T> (
    val isRequestSuccess: Boolean=false,
    val responseBody: T?,
    val errorResponse: ErrorResponse = ErrorResponse()
)