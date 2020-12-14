package br.com.apinteractive.starwarsapp.data.model

import com.squareup.moshi.Json

data class MoviesResult(
    @Json(name = "count")
    val filmCount: Int,
    @Json(name = "next")
    val nextPageUri: String?,
    @Json(name = "previous")
    val previousPageUri: String?,
    @Json(name = "results")
    val results: List<Movie>
)
