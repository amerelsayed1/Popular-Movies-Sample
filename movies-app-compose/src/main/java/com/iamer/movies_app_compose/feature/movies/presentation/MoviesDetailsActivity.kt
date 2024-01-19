package com.iamer.movies_app_compose.feature.movies.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.iamer.movies_app_compose.ui.theme.PopularMoviesSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailsActivity : ComponentActivity() {


    private val moviesHomeMoviesViewModel: HomeMoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PopularMoviesSampleTheme {
                intent?.getIntExtra("movieId", 0)?.apply {
                    moviesHomeMoviesViewModel.getMovieDetails(this)
                }
                MovieDetailsScreen(moviesHomeMoviesViewModel)
            }
        }
    }
}