package com.example.examen.framework.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.network.models.MovieDetails
import com.example.examen.domain.usecase.PopularListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    val popularListLiveData = MutableLiveData<ArrayList<MovieDetails>?>()
    private val popularListRequirement = PopularListRequirement()

    fun fetchAllPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {

            val data = popularListRequirement()
            CoroutineScope(Dispatchers.Main).launch {
                popularListLiveData.postValue(data)
            }
        }
    }


}