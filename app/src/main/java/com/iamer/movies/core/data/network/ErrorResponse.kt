package com.iamer.movies.core.data.network

data class ErrorResponse( var errors: ArrayList<String> = ArrayList(),
                          var message: String = "")