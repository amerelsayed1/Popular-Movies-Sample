package com.iamer.movies.features.movies.data.network

import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.data.models.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/search/movie")
    fun searchMoviesAndSeries(
        @Query("api_key") apiKey: String = "285dcedfc17a8c1cc87ff6b166092aec",
        @Query("query") query: String,
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("3/movie/upcoming")
    fun popularMovies(
        @Query("api_key") apiKey: String = "285dcedfc17a8c1cc87ff6b166092aec",
    ): Call<MoviesResponse>


    @GET("3/movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = "285dcedfc17a8c1cc87ff6b166092aec",
    ): Call<Movie>

}