package com.iamer.movies.features.movies.data.network

import com.iamer.movies.core.network.ResponseBase
import com.iamer.movies.features.movies.data.models.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/search/movie")
    fun movies(
        @Query("api_key") apiKey: String = "2696829a81b1b5827d515ff121700838",
        @Query("query") query: String,
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("3/movie/popular")
    fun popularMovies(
        @Query("api_key") apiKey: String = "2696829a81b1b5827d515ff121700838",
        @Query("page") page: Int
    ): Call<MoviesResponse>

}