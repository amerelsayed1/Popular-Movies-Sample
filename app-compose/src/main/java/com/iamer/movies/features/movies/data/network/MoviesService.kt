package com.iamer.movies.features.movies.data.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesService @Inject constructor(retrofit: Retrofit) : MoviesApi {

    private val moviesApi by lazy { retrofit.create(MoviesApi::class.java) }
    override fun searchMoviesAndSeries(apiKey: String, query: String, page: Int) =
        moviesApi.searchMoviesAndSeries(apiKey, query, page)

    override fun popularMovies(apiKey: String) =
        moviesApi.popularMovies(apiKey)

    override fun getMovieDetails(movieId: Int, apiKey: String) =
        moviesApi.getMovieDetails(movieId = movieId)
}