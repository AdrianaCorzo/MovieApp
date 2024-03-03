package com.nebrija.movieapp.models

import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("current_page")
    val currentPage: String,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("page_count")
    val pageCount: Int,
    @SerializedName("total_count")
    val totalCount: Int
)
