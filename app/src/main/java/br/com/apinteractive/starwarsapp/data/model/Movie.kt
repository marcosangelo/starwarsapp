package br.com.apinteractive.starwarsapp.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @Json(name = "title")
    val filmTitle: String?,
    @Json(name = "episode_id")
    val episodeId: String,
    @Json(name = "opening_crawl")
    val openingCrawl: String,
    @Json(name = "director")
    val director: String,
    @Json(name = "producer")
    val producer: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "created")
    val created: String,
    @Json(name = "url")
    val filmUrl: String
) : Parcelable {}