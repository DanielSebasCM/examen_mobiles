package com.example.examen.data.network.survey

import com.example.examen.data.network.NetworkModule
import com.example.examen.data.network.models.Template
import com.greencircle.data.remote.survey.APIService
import java.util.Optional


class APIClient {
    private lateinit var api: APIService

    suspend fun getTemplate(): Optional<Template> {
        api = NetworkModule(APIService::class.java)
        return try {
            return Optional.ofNullable(api.getTemplate())
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Optional.empty()
        }
    }
}
