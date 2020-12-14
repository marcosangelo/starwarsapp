package br.com.apinteractive.starwarsapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.apinteractive.starwarsapp.data.model.Movie
import br.com.apinteractive.starwarsapp.data.repository.SwApiRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _repository by lazy {
        SwApiRepository()
    }


    private val _allMovies = MutableLiveData<List<Movie>>()

    val allMovies: LiveData<List<Movie>> get() = _allMovies

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            try {
                _allMovies.value = _repository.movies()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}