package br.com.apinteractive.starwarsapp.ui.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.apinteractive.starwarsapp.data.model.Movie

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _movie = MutableLiveData<Movie>()

    val movie: LiveData<Movie> = _movie


    fun loadArgs(movie: Movie) {
        _movie.value = movie
    }
}