package com.nebrija.movieapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nebrija.movieapp.models.Data
import com.nebrija.movieapp.utils.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel : ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())

    private val _listaMovies = MutableLiveData<List<Data>>()
    var listaMovies: LiveData<List<Data>> = _listaMovies

    init {
        // Llama a la función fetchMovies para obtener la lista de películas
        fetchMovies(state.page)
    }

    // Función para obtener la lista de películas
    private fun fetchMovies(page: Int) {
        viewModelScope.launch {
            val response = repository.getMovieList(page)
            if (response.isSuccessful) {
                val moviesData = response.body()?.data ?: emptyList()
                _listaMovies.value = moviesData

            }
        }
    }
}
data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1
)