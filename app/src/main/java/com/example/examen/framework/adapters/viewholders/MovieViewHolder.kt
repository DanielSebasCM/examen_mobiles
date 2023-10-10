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
 * Esta clase se utiliza para almacenar los datos de
 * una película y crear la vista de la
 * tarjeta de la película
 * @property binding: Objeto ItemMovieBinding
 * @constructor MovieViewHolder
 */

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

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