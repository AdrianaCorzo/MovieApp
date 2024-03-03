package com.nebrija.movieapp.utils

import com.nebrija.movieapp.models.MovieList
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page:Int): Response<MovieList>{
        return RetrofitInstance.api.getMovies(page)
    }

}