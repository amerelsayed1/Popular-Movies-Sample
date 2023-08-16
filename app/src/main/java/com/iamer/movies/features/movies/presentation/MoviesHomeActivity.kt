package com.iamer.movies.features.movies.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iamer.movies.R
import com.iamer.movies.core.extension.observe
import com.iamer.movies.core.network.ResponseBase
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.core.platform.BaseActivity
import com.iamer.movies.databinding.ActivityMainBinding
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.data.models.MoviesResponse
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
                HomeScreen(moviesHomeMoviesViewModel)
            }
        }
    }

    /*private val moviesAdapter: MoviesAdapter by lazy(LazyThreadSafetyMode.PUBLICATION) {
        MoviesAdapter()
    }

    private lateinit var composeView: ComposeView*/

    //override fun viewBinding() = ActivityMainBinding.inflate(layoutInflater)

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        composeView = ComposeView(applicationContext)


        setContent {
            FirstScreen()
        }

        *//*setRvMovie()

        moviesHomeMoviesViewModel.getMovies()

        with(moviesHomeMoviesViewModel) {
            observe(movies, ::renderMoviesList)
        }
*//*

    }*/

    private fun setRvMovie() {
        /* viewBinding?.rvMovies?.apply {
             val rvMenuItemLayoutManager =
                 LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
             layoutManager = rvMenuItemLayoutManager
             adapter = moviesAdapter
         }

         moviesAdapter.clickListener = { movie ->
             Intent(this@MoviesHomeActivity, MoviesDetailsActivity::class.java).apply {
                 putExtra("movieId", movie?.id)
                 startActivity(this)
             }
         }*/
    }

    private fun renderMoviesList(status: DataState<MoviesResponse>) {
        /*when (status) {

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

        }*/
    }

}