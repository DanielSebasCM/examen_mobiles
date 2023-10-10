package com.greencircle.data.remote.survey

import com.example.examen.data.network.models.PopularListResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interface that defines the API calls for the IMDB API
 */
interface APIService {
    @GET("3/movie/popular")
    suspend fun getTemplate(): Response<PopularListResponse>

}
