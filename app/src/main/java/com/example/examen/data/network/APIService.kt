package com.greencircle.data.remote.survey

import com.example.examen.data.network.models.Template
import retrofit2.http.GET

interface APIService {
    @GET("template")
    suspend fun getTemplate(): Template?

}
