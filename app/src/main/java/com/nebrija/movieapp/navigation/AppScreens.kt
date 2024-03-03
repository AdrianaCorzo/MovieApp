package com.nebrija.movieapp.navigation

sealed class AppScreens (var route: String) {
    object InicioView: AppScreens("InicioView");
    object MoviesView: AppScreens("MoviesView");


}