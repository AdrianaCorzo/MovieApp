package com.nebrija.movieapp.models

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("metadata")
    val metadata: Metadata
)
