package com.nebrija.movieapp.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.nebrija.movieapp.navigation.AppScreens
import com.nebrija.movieapp.viewModel.MovieViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioView(navController: NavHostController) {
    val movieViewModel: MovieViewModel = viewModel()
    val listaMovies by movieViewModel.listaMovies.observeAsState(emptyList())
    val state = movieViewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2C3981)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Toda la información sobre tus películas favoritas",
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(listaMovies.size) { data ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var id = listaMovies[data].id
                    Image(
                        painter = rememberImagePainter(listaMovies[data].poster),
                        contentDescription = listaMovies[data].title,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(200.dp)
                            .clickable { navController.navigate(AppScreens.MoviesView.route + "${id}") }
                        //navController.navigate(
                        //                "${AppScreens.MovieView.route}/${listaMovies[data].id}"
                        //            )
                    )

                    Text(
                        text = listaMovies[data].title,
                        color = Color.White,

                        )

                }
            }
        }
    }
}
