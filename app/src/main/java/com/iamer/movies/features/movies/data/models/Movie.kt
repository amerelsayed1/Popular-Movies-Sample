package com.iamer.movies.features.movies.data.models


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("popularity")
    var popularity: Double = 0.0,
    @SerializedName("vote_count")
    var voteCount: Int = 0,
    @SerializedName("video")
    var video: Boolean = false,
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("adult")
    var adult: Boolean = false,
    @SerializedName("backdrop_path")
    var backdropPath: String? = "",
    @SerializedName("original_language")
    var originalLanguage: String = "",
    @SerializedName("original_title")
    var originalTitle: String = "",
    @SerializedName("genre_ids")
    var genreIds: List<Int> = arrayListOf(),
    @SerializedName("title")
    var title: String = "",
    @SerializedName("vote_average")
    var voteAverage: Float = 0.0f,
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("release_date")
    var releaseDate: String = ""
) {

    val imageUrl: String
        get() = "https://image.tmdb.org/t/p/w780${backdropPath}"

}