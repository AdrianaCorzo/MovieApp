package com.nebrija.movieapp.domain

import com.nebrija.movieapp.models.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movies?/page=1")
    suspend fun getMovies(
        @Query("page")page:Int
    ): Response<MovieList>
}