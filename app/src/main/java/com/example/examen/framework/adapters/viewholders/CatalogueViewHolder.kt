package com.example.examen.framework.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.examen.data.network.models.MovieDetails
import com.example.examen.databinding.ItemMovieBinding
import com.example.examen.utils.Constants

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

    fun bind(movieDetails: MovieDetails, context: Context) {
        binding.TVTitle.text = movieDetails.title
        binding.TVDescription.text = movieDetails.overview

        val requestOptions =
            RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter().priority(Priority.HIGH)

        Glide.with(context).load(Constants.IMAGE_SERVER_URL + movieDetails.poster_path)
            .apply(requestOptions).into(binding.IVMovie)

    }
}