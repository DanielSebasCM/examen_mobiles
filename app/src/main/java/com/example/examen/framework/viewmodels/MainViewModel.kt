package com.example.examen.framework.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.network.models.MovieDetails
import com.example.examen.domain.usecase.PopularListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Esta clase se utiliza para almacenar los datos de resumen de
 * la empresa y crear la vista de la tarjeta del catálogo de la empresa
 */

class MainViewModel() : ViewModel() {
    val popularListLiveData = MutableLiveData<ArrayList<MovieDetails>?>()
    private val popularListRequirement = PopularListRequirement()

    /**
     * Esta función se utiliza para obtener la lista de resumen de la empresa
     */
    fun fetchAllPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {

            val data = popularListRequirement()
            CoroutineScope(Dispatchers.Main).launch {
                popularListLiveData.postValue(data)
            }
        }
    }


}