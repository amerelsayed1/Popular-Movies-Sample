package com.iamer.movies_app_compose.feature.movies.domain.use_case

import com.iamer.movies.core.network.usecase.UseCase
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.domain.repositories.MoviesRepository
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(private val moviesRepository: MoviesRepository) :
    UseCase<Movie, MovieDetailsUseCase.Params>() {

    data class Params(val movieId: Int)

    override suspend fun run(params: Params) =
        moviesRepository.getMovieDetails(movieId = params.movieId)
}