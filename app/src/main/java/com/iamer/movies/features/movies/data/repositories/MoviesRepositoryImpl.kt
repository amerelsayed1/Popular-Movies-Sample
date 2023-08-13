package com.iamer.movies.features.movies.data.repositories

import com.iamer.movies.core.network.NetworkHandler
import com.iamer.movies.core.network.RequestHelper.request
import com.iamer.movies.core.network.ResponseBase
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.features.movies.data.models.MoviesResponse
import com.iamer.movies.features.movies.data.network.MoviesApi
import com.iamer.movies.features.movies.domain.repositories.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val service: MoviesApi
) : MoviesRepository {
    override fun getMovies(query: String, page: Int): DataState<MoviesResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                service.movies(query = query, page = page),
                MoviesResponse()
            )
            false -> DataState.Failure("")
        }
    }

    override fun getPopularMovies(
        query: String,
        page: Int
    ): DataState<MoviesResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                service.popularMovies( page = page),
                MoviesResponse()
            )
            false -> DataState.Failure("")
        }
    }
}