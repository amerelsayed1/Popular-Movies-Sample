package com.iamer.movies.features.movies.data.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesService @Inject constructor(retrofit: Retrofit) : MoviesApi {

    private val moviesApi by lazy { retrofit.create(MoviesApi::class.java) }
    override fun movies(apiKey: String, query: String, page: Int) =
        moviesApi.movies(apiKey, query, page)

    override fun popularMovies(apiKey: String, page: Int) =
        moviesApi.popularMovies(apiKey, page)
}