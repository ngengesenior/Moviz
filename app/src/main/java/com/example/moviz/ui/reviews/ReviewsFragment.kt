package com.example.moviz.ui.reviews


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.example.moviz.R
import com.example.moviz.adapter.ReviewsController
import com.example.moviz.datasource.custom.CustomViewModelFactory
import kotlinx.android.synthetic.main.fragment_reviews.*

/**
 * A simple [Fragment] subclass.
 */
class ReviewsFragment : Fragment() {

    val args:ReviewsFragmentArgs by navArgs()
    private lateinit var reviewsViewModel: ReviewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reviewsViewModel = ViewModelProviders.of(this,CustomViewModelFactory(args.movieId))
            .get(ReviewsViewModel::class.java)
        val reviewsController = ReviewsController()
        reviewsRecyclerview.adapter =reviewsController.adapter
        reviewsRecyclerview.setItemSpacingDp(4)
        reviewsViewModel.reviewsLiveData.observe(this, Observer {
            reviewsController.submitList(it)
        })





    }


}
