package com.iamer.movies.features.movies.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.iamer.movies.R
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies.features.movies.data.models.MoviesResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeMoviesViewModel: HomeMoviesViewModel) {

    val result = homeMoviesViewModel.movies.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Popular Movies")
                },
                navigationIcon = {

                },
                actions = {

                },
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when (val response = result.value) {
                    is DataState.Loading -> {

                    }

                    is DataState.Success -> {
                        RecyclerView(response.response.data)
                    }

                    is DataState.Failure -> {

                    }

                    else -> {

                    }
                }
            }
        }
    )
}

private fun renderMoviesList(status: DataState<MoviesResponse>) {
    when (status) {

        is DataState.Loading -> {

        }

        is DataState.Success -> {

        }

        is DataState.Failure -> {

        }

    }
}

@Composable
fun RecyclerView(
    movies: List<Movie>
) {
    LazyColumn(

    ) {

        items(items = movies) { movie ->
            ItemListMovie(movie)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemListMovie(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row {

            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(140.dp),
            ) {
                GlideImage(
                    model = movie.imageUrl,
                    contentDescription = stringResource(id = R.string.item_movie_content_description),

                    contentScale = ContentScale.FillBounds
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    movie.title,
                    maxLines = 1,
                    modifier = Modifier
                        .padding(start = 8.dp),
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    movie.overview,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    maxLines = 2,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 6.dp),
                )
            }
        }
    }
}
