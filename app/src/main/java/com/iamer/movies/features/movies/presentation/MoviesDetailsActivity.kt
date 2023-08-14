package com.iamer.movies.features.movies.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.iamer.movies.core.extension.loadFromUrl
import com.iamer.movies.core.extension.observe
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.core.platform.BaseActivity
import com.iamer.movies.databinding.ActivityMovieDetailsBinding
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.data.models.MoviesResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailsActivity : BaseActivity<ActivityMovieDetailsBinding>() {

    private val moviesHomeMoviesViewModel: HomeMoviesViewModel by viewModels()

    override fun viewBinding() = ActivityMovieDetailsBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent?.getIntExtra("movieId", 0)?.apply {
            moviesHomeMoviesViewModel.getMovieDetails(this)
        }

        with(moviesHomeMoviesViewModel) {
            observe(movie, ::renderMovie)
        }
    }

    private fun renderMovie(status: DataState<Movie>) {
        when (status) {

            is DataState.Loading -> {

            }

            is DataState.Success -> {
                viewBinding?.apply {
                    moviePoster.loadFromUrl(status.response.imageUrl)
                    tvMovieSummary.text = status.response.overview
                    tvMovieReleaseDate.text = status.response.releaseDate
                }
            }

            is DataState.Failure -> {

            }

        }
    }

}