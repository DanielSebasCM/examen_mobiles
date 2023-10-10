package com.example.examen.data.repository

import com.example.examen.data.network.models.Template
import com.example.examen.data.network.survey.APIClient

class TemplateRepository() {
    private val apiTemplate = APIClient()

    suspend fun getPokemonList(): Template? = apiTemplate.getTemplate()

}