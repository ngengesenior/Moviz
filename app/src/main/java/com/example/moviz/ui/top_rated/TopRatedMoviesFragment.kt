package com.example.moviz.ui.top_rated

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
import kotlinx.android.synthetic.main.fragment_top_rated.view.*

class TopRatedMoviesFragment : Fragment() {

    private lateinit var topRatedMoviesViewModel: TopRatedMoviesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        topRatedMoviesViewModel = ViewModelProviders.of(this).get(TopRatedMoviesViewModel::class.java)


        val root = inflater.inflate(R.layout.fragment_top_rated, container, false)
        val moviesListController = MoviesController(object : MovieClickListener {
            override fun onMovieItemClicked(movie: Movie) {

                val action =  TopRatedMoviesFragmentDirections.topRatedToDetails(movie)
                root.findNavController().navigate(action)

            }

        })

        root.topRatedRecyclerview.setupGridManager(moviesListController)
        topRatedMoviesViewModel.popularMoviesLiveData.observe(this, Observer {
            moviesListController.submitList(it)
        })

        return root
    }
}