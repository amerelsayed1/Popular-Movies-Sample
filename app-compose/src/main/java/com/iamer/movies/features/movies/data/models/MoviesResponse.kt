package com.iamer.movies.features.movies.data.models

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page")
    var page: Int = 0,
    @SerializedName("total_results")
    var totalResults: Int = 0,
    @SerializedName("total_pages")
    var totalPages: Int = 0,
    @SerializedName("results")
    var data: ArrayList<Movie> = arrayListOf()
)