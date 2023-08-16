package com.iamer.movies.features.movies.data.repositories

import com.iamer.movies.core.network.NetworkHandler
import com.iamer.movies.core.network.RequestHelper.request
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.data.models.MoviesResponse
import com.iamer.movies.features.movies.data.network.MoviesApi
import com.iamer.movies.features.movies.domain.repositories.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val service: MoviesApi
) : MoviesRepository {
    override fun searchMoviesAndSeries(query: String, page: Int): DataState<MoviesResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                service.searchMoviesAndSeries(query = query, page = page),
                MoviesResponse()
            )

            false -> DataState.Failure("")
        }
    }

    override fun getMovieDetails(movieId: Int): DataState<Movie> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                service.getMovieDetails(movieId=movieId),
                Movie()
            )

            false -> DataState.Failure("")
        }
    }

    override fun getPopularMovies(): DataState<MoviesResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                service.popularMovies(),
                MoviesResponse()
            )

            false -> DataState.Failure("")
        }
    }
}