package com.nebrija.movieapp.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.nebrija.movieapp.navigation.AppScreens
import com.nebrija.movieapp.viewModel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesView(navController: NavHostController, id: Int?) {
    val movieViewModel: MovieViewModel = viewModel()
    val listaMovies by movieViewModel.listaMovies.observeAsState(emptyList())
    val state = movieViewModel.state
    var idMovie = id!!

    if (id != null) {
        val movie = listaMovies.find { movieBuscada -> movieBuscada.id.toInt() == id.toInt() }
        if (movie != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF2C3981)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = rememberImagePainter(movie!!.poster),
                    contentDescription = movie!!.title,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(400.dp)
                        .clickable { navController.navigate(AppScreens.MoviesView.route) }
                )

                Text(
                    text = movie!!.title,
                    color = Color.White,

                    )
                Text(
                    text = "Año: ${movie!!.year}",
                    color = Color.White,

                    )
                Text(
                    text = "Rating: ${movie!!.imdbRating}",
                    color = Color.White,

                    )
                Text(
                    text = "País: ${movie!!.country}",
                    color = Color.White,

                    )
                Text(
                    text = "Género: ${movie!!.genres}",
                    color = Color.White,

                    )

                val images: List<String> = movie!!.images
                LazyRow {
                    items(images.size) { index ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),

                            ) {

                            Image(
                                painter = rememberImagePainter(images[index].toString()),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(200.dp)

                            )

                        }
                    }
                }
            }
        }
    }
}