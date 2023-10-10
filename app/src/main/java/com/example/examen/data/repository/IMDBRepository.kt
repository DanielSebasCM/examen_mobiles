package com.example.examen.data.repository

import com.example.examen.data.network.models.MovieDetails
import com.example.examen.data.network.survey.APIClient

class IMDBRepository() {
    private val api = APIClient()

    suspend fun getPopularList(): ArrayList<MovieDetails> {
        return when (val response = api.getPopulatList()) {
            null -> arrayListOf()
            else -> response.results
        }
    }

}