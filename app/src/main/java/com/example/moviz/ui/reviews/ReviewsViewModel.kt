package com.example.moviz.ui.reviews

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviz.api.TmdbService
import com.example.moviz.data.Review
import com.example.moviz.datasource.PageKeyMoviesFactory
import com.example.moviz.datasource.PageKeyReviewsFactory
import java.util.concurrent.Executor

class ReviewsViewModel(val id:Int): ViewModel()
{

    var reviewsLiveData: LiveData<PagedList<Review>>
    private val pageSize = 25
    private val reviewsFactory: PageKeyReviewsFactory = PageKeyReviewsFactory(TmdbService.create(), id, Executor {

    })

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(5)
            .setEnablePlaceholders(false)
            .build()

        reviewsLiveData = LivePagedListBuilder(reviewsFactory,config).build()

    }







}