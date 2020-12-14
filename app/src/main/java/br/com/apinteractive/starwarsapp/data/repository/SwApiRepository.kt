package br.com.apinteractive.starwarsapp.data.repository

import br.com.apinteractive.starwarsapp.data.model.Movie
import br.com.apinteractive.starwarsapp.data.service.Swapi

class SwApiRepository {
    suspend fun movies(): List<Movie> {
        return try {
            val result = Swapi.retrofitService.getMoviesAsync().await().results
            result
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception(e)
        }
    }

    suspend fun movie(movieId: String): Movie {
        return try {
            val result = Swapi.retrofitService.getMovieAsync(movieId = movieId).await()
            result
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception(e)
        }
    }
}