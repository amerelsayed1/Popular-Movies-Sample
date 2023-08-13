package com.iamer.movies.core.data.network


class ResponseErrorException(val errorModel: ErrorResponse) : Exception()
