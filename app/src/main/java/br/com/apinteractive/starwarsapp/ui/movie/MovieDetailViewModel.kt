package br.com.apinteractive.starwarsapp.ui.movie

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.apinteractive.starwarsapp.data.model.Movie
import br.com.apinteractive.starwarsapp.data.repository.SwApiRepository
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var _movieId: String

    private val _repository by lazy {
        SwApiRepository()
    }
    private val _movie = MutableLiveData<Movie>()

    val movie: LiveData<Movie> = _movie


    fun loadArgs(movieUrl: String) {
        _movieId = movieUrl
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            try {
                _movie.value = _repository.movie(movieId = _movieId)
                print(_movie.value!!.filmTitle)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}