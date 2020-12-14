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

    val isLoading = MutableLiveData<Boolean?>()

    private val _allMovies = MutableLiveData<List<Movie>>()

    val allMovies: LiveData<List<Movie>> get() = _allMovies

    init {
        isLoading.postValue(true)
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            try {
                _allMovies.value = _repository.movies()
                isLoading.postValue(false)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}