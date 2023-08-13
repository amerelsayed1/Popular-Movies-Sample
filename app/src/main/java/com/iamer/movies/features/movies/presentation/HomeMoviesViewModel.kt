package com.iamer.movies.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamer.movies.core.network.ResponseBase
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.features.movies.data.models.MoviesResponse
import com.iamer.movies.features.movies.domain.use_case.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeMoviesViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase) :
    ViewModel() {

    private val _movies: MutableLiveData<DataState<MoviesResponse>> = MutableLiveData()
    val movies: LiveData<DataState<MoviesResponse>> = _movies
    fun getMovies() {
        moviesUseCase(
            MoviesUseCase.Params(query = "", page = 1),
            viewModelScope
        ) {
            _movies.value = it
        }
    }

}