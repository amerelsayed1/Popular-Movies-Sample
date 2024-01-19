package com.iamer.movies_app_compose.feature.movies.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.iamer.movies.core.network.usecase.DataState
import com.iamer.movies.features.movies.data.models.Movie
import com.iamer.movies_app_compose.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(homeMoviesViewModel: HomeMoviesViewModel) {

    val result = homeMoviesViewModel.movie.observeAsState()

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
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is DataState.Success -> {
                        MovieDetails(response.response)
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


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetails(
    movie: Movie
) {
    Column {
        GlideImage(
            model = movie.imageUrl,
            contentDescription = stringResource(id = R.string.item_movie_content_description),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        )
        Text(
            text = stringResource(id = R.string.movie_details_summary),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = movie.overview,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
        )
        Text(
            text = stringResource(id = R.string.movie_release_date),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = movie.releaseDate,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
        )
    }
}
