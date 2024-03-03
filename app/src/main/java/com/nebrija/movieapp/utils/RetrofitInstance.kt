package com.nebrija.movieapp.utils

import com.google.gson.GsonBuilder
import com.nebrija.movieapp.domain.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.time.LocalDate

object RetrofitInstance {
    val api: ApiInterface by lazy {
        val gson = GsonBuilder()
            .create()

            Retrofit.Builder()
                .baseUrl(Util.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)

    }
}