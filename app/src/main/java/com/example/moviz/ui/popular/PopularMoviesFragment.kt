package com.example.moviz.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.moviz.R
import com.example.moviz.adapter.MovieClickListener
import com.example.moviz.adapter.MoviesController
import com.example.moviz.data.Movie
import com.example.moviz.utils.setupGridManager
import kotlinx.android.synthetic.main.fragment_popular.view.*

class PopularMoviesFragment : Fragment() {

    private lateinit var popularMoviesViewModel: PopularMoviesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        popularMoviesViewModel = ViewModelProviders.of(this).get(PopularMoviesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_popular, container, false)
        val moviesListController = MoviesController(object : MovieClickListener {
            override fun onMovieItemClicked(movie: Movie) {
               val action =  PopularMoviesFragmentDirections.popularToDetails(movie)
                root.findNavController().navigate(action)
            }

        })

        root.popularRecyclerview.setupGridManager(moviesListController)


        popularMoviesViewModel.popularMoviesLiveData.observe(this, Observer {
            moviesListController.submitList(it)
        })

        return root
    }


}