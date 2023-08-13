package com.iamer.movies.core.data.network

data class NetworkOutcome<T>(val isRequestSuccess: Boolean,
                             val responseBody: T?,
                             val errorResponse: ErrorResponse)