package com.iamer.movies.features.movies.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.iamer.movies.ui.theme.MostPopularMoviesSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesHomeActivity : ComponentActivity() {

    private val moviesHomeMoviesViewModel: HomeMoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MostPopularMoviesSampleTheme {
                moviesHomeMoviesViewModel.getMovies()
                MoviesHomeScreen(moviesHomeMoviesViewModel)
            }
        }
    }

}