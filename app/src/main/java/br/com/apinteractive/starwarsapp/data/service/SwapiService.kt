package br.com.apinteractive.starwarsapp.data.service

import br.com.apinteractive.starwarsapp.data.model.Movie
import br.com.apinteractive.starwarsapp.data.model.MoviesResult
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://swapi.dev/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface SwapiService {

    @GET("films")
    fun getMoviesAsync(): Deferred<MoviesResult>

//    @GET("films/{movieId}")
//    fun getMovieAsync(@Path("movieId") movieId: String): Deferred<Movie>

    @GET("films/{movieId}")
    fun getMovieAsync(@Path("movieId") movieId: String):  Deferred<Movie>
}

object Swapi {
    val retrofitService: SwapiService by lazy { retrofit.create(SwapiService::class.java) }
}