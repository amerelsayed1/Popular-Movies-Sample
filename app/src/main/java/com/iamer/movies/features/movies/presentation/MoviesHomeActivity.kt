package com.iamer.movies.features.movies.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamer.movies.core.extension.observe
import com.iamer.movies.core.network.ResponseBase
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.core.platform.BaseActivity
import com.iamer.movies.databinding.ActivityMainBinding
import com.iamer.movies.features.movies.data.models.MoviesResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesHomeActivity : BaseActivity<ActivityMainBinding>() {

    private val moviesHomeMoviesViewModel: HomeMoviesViewModel by viewModels()

    private val moviesAdapter: MoviesAdapter by lazy(LazyThreadSafetyMode.PUBLICATION) {
        MoviesAdapter()
    }

    override fun viewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRvMovie()

        moviesHomeMoviesViewModel.getMovies()

        with(moviesHomeMoviesViewModel) {
            observe(movies, ::renderMoviesList)
        }


    }

    private fun setRvMovie() {
        viewBinding?.rvMovies?.apply {
            val rvMenuItemLayoutManager =
                LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            layoutManager = rvMenuItemLayoutManager
            adapter = moviesAdapter
        }
    }

    private fun renderMoviesList(status: DataState<MoviesResponse>) {
        when (status) {

            is DataState.Loading -> {
                viewBinding?.progressBarLoading?.visibility = View.VISIBLE
            }

            is DataState.Success -> {
                viewBinding?.progressBarLoading?.visibility = View.GONE
                moviesAdapter.submitList(status.response.data)
            }

            is DataState.Failure -> {
                viewBinding?.progressBarLoading?.visibility = View.GONE
            }

        }
    }

}