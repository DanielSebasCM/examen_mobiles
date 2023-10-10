package com.example.examen.framework.views.activities

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.databinding.ActivityMainBinding
import com.example.examen.databinding.FragmentErrorBinding
import com.example.examen.framework.adapters.MovieAdapter
import com.example.examen.framework.viewmodels.MainViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit private var viewModel: MainViewModel
    lateinit var recicleView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this)[MainViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.fetchAllPopularMovies()

        // Bindings
        recicleView = binding.RVPopularList


        // Observers
        viewModel.popularListLiveData.observe(this) { list ->
            if (!list.isNullOrEmpty()) {
                binding.root.removeView(binding.skeleton.root)
                val adapter = MovieAdapter()
                adapter.initCustomAdapter(list, this)
                recicleView.adapter = adapter
            } else {
                Log.i("Salida", "No hay datos")
                binding.root.removeView(recicleView)
                binding.root.removeView(binding.skeleton.root)
                val errorView = FragmentErrorBinding.inflate(layoutInflater).root
                binding.LLContainer.addView(errorView)
                errorView.layoutParams.height = LayoutParams.MATCH_PARENT
                errorView.layoutParams.width = LayoutParams.MATCH_PARENT

            }
        }
    }
}
