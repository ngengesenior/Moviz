package com.example.moviz.ui.details


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moviz.R
import com.example.moviz.data.Movie
import com.example.moviz.utils.getAppendedString
import com.example.moviz.utils.loadTmdbImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_details.*
import java.lang.StringBuilder

/**
 * A simple [Fragment] subclass.
 */
class MovieDetailsFragment : Fragment() {

    val args:MovieDetailsFragmentArgs by navArgs()
    private var movieId:Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = args.movieArg


       movie?.let {
           movieId = it.id.toInt()
           movieImageView.loadTmdbImage(it.backdropPath)
           textViewTitle.text = it.title
           textViewOverview.text = it.overview
           releaseDateView.text = it.releaseDate.split("-")[0]
           ratingBar.rating = it.voteAverage.div(2).toFloat()
           Log.d("TAG","${movie.genres}")
           //genreTextView.text = getAppendedString(it.genres)


       }

        buttonReviews.setOnClickListener {
            val action = MovieDetailsFragmentDirections.actionMovieDetailsFragmentToReviewsFragment(movieId)
            findNavController().navigate(action)
        }
    }




}
