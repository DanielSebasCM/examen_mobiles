package com.example.examen.data.network.models

/**
 * Dataclass that represents the response from the API
 */
data class PopularListResponse(
    val page: Int,
    val results: ArrayList<MovieDetails>,
    val total_pages: Int,
    val total_results: Int
)