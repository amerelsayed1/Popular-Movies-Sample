package com.iamer.movies.features.movies.domain.repositories

import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.data.models.MoviesResponse

/**
 * Amer Elsayed
 * dev.amer.elsayed@gmail.com
 * 05/05/2020
 */
interface MoviesRepository {
    fun searchMoviesAndSeries(query: String, page: Int): DataState<MoviesResponse>
    fun getMovieDetails(movieId: Int): DataState<Movie>
    fun getPopularMovies(): DataState<MoviesResponse>
}