package com.example.examen.framework.views.activities

import android.os.Bundle
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
            if (list != null) {

                binding.root.removeView(binding.skeleton.root)
                val adapter = MovieAdapter()
                adapter.initCustomAdapter(list, this)
                recicleView.adapter = adapter
            } else {
                binding.root.removeView(recicleView)
                binding.LLContainer.addView(FragmentErrorBinding.inflate(layoutInflater).root)
            }
        }
    }
}
