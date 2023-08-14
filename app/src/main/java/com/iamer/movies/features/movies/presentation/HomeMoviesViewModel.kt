package com.iamer.movies.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamer.movies.core.network.ResponseBase
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.core.network.usecase.UseCase
import com.iamer.movies.features.movies.data.models.MoviesResponse
import com.iamer.movies.features.movies.domain.use_case.MoviesUseCase
import com.iamer.movies.features.movies.domain.use_case.SearchMoviesAndSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeMoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase,
    private val searchMoviesAndSeriesUseCase: SearchMoviesAndSeriesUseCase
) :
    ViewModel() {

    private val _movies: MutableLiveData<DataState<MoviesResponse>> = MutableLiveData(DataState.Loading)
    val movies: LiveData<DataState<MoviesResponse>> = _movies

    fun getMovies() {
        moviesUseCase(
            UseCase.None(),
            viewModelScope
        ) {
            _movies.value = it
        }
    }

}