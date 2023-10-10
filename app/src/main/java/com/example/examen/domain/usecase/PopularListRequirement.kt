package com.example.examen.domain.usecase

import com.example.examen.data.network.models.MovieDetails
import com.example.examen.data.repository.IMDBRepository

class PopularListRequirement {
    private val repository = IMDBRepository()

    suspend operator fun invoke(): ArrayList<MovieDetails>? = repository.getPopularList()
}