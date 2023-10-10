package com.example.examen.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.models.MovieDetails
import com.example.examen.databinding.ItemMovieBinding
import com.example.examen.framework.adapters.viewholders.MovieViewHolder

/**
 * Esta clase se utiliza para almacenar los datos de
 * resumen de la empresa y crear la vista de la
 * tarjeta del catálogo de la empresa
 */

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private var data: ArrayList<MovieDetails> = ArrayList()
    lateinit var context: Context

    fun initCustomAdapter(data: ArrayList<MovieDetails>, context: Context) {
        this.data = data
        this.context = context
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MovieViewHolder {
        val v = ItemMovieBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return MovieViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        val item = data[position]
        viewHolder.bind(item, context)
    }

    /**
     * Esta función se utiliza para obtener el número de elementos de la lista
     * @return Valor entero
     */
    override fun getItemCount(): Int {
        return data.size
    }
}
