package com.example.examen.domain.usecase

import com.example.examen.data.network.models.MovieDetails
import com.example.examen.data.repository.IMDBRepository


/**
 * Use case that gets a list of popular movies
 */
class PopularListRequirement {
    private val repository = IMDBRepository()

    suspend operator fun invoke(): ArrayList<MovieDetails>? = repository.getPopularList()
}