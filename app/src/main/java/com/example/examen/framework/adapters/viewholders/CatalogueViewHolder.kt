package com.example.examen.framework.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examen.data.network.models.MovieDetails
import com.example.examen.databinding.ItemMovieBinding

/**
 * Esta clase se utiliza para almacenar los datos de resumen
 * de la empresa y crear la vista de la tarjeta del
 * catálogo de la empresa
 * @property binding: Objeto CatalogueCardLayoutBinding
 * @constructor CatalogueViewHolder
 */

class CatalogueViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Esta función se utiliza para vincular los datos de resumen de la empresa
     * con la vista de la tarjeta del catálogo de la empresa
     * @param companySummary: Objeto CompanySummary
     */

    fun bind(movieDetails: MovieDetails) {
        binding.TVTitle.text = movieDetails.title
        binding.TVDescription.text = movieDetails.overview
    }
}