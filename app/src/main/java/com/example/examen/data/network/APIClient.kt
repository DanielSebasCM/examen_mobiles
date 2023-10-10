package com.example.examen.data.network.survey

import com.example.examen.data.network.NetworkModule
import com.example.examen.data.network.models.PopularListResponse
import com.greencircle.data.remote.survey.APIService


class APIClient {
    private lateinit var api: APIService

    suspend fun getPopulatList(): PopularListResponse? {
        api = NetworkModule(APIService::class.java)
        return try {
            val response = api.getTemplate()
            when (response.isSuccessful) {
                true -> response.body()
                false -> null
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}
