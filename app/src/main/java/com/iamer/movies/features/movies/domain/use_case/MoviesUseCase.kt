package com.iamer.movies.features.movies.domain.use_case

import com.iamer.movies.core.network.ResponseBase
import com.iamer.movies.core.network.usecase.UseCase
import com.iamer.movies.features.movies.data.models.MoviesResponse
import com.iamer.movies.features.movies.domain.repositories.MoviesRepository
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) :
    UseCase<MoviesResponse, MoviesUseCase.Params>() {

    data class Params(val query: String, val page: Int)

    override suspend fun run(params: Params) =
        moviesRepository.getPopularMovies(params.query, params.page)
}