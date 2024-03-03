package com.nebrija.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nebrija.movieapp.Views.InicioView
import com.nebrija.movieapp.Views.MoviesView

@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.InicioView.route)
    {

        composable(AppScreens.InicioView.route) { InicioView(navigationController) }

        composable(AppScreens.MoviesView.route+ "{id}" ,
            arguments = listOf(navArgument(name = "id")
            {type = NavType.IntType})) {
            MoviesView(navigationController, it.arguments?.getInt("id")) }

    }
}