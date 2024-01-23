package com.iamer.movies_app_compose.feature.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.core.network.usecase.UseCase
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.data.models.MoviesResponse
import com.iamer.movies_app_compose.feature.movies.domain.use_case.MovieDetailsUseCase
import com.iamer.movies_app_compose.feature.movies.domain.use_case.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeMoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase,
    private val movieDetailsUseCase: MovieDetailsUseCase,
) :
    ViewModel() {

    private val _movies: MutableLiveData<DataState<MoviesResponse>> =
        MutableLiveData(DataState.Loading)
    val movies: LiveData<DataState<MoviesResponse>> = _movies


    private val _movie: MutableLiveData<DataState<Movie>> =
        MutableLiveData(DataState.Loading)
    val movie: LiveData<DataState<Movie>> = _movie

    fun getMovies() {
        moviesUseCase(
            UseCase.None(),
            viewModelScope
        ) {
            _movies.value = it
        }
    }

    fun getMovieDetails(movieId: Int) {
        movieDetailsUseCase(
            MovieDetailsUseCase.Params(movieId = movieId),
            viewModelScope
        ) {
            _movie.value = it
        }
    }

}