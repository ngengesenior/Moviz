package com.example.moviz.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviz.api.TmdbService
import com.example.moviz.data.Review
import java.util.concurrent.Executor

class PageKeyReviewsFactory(val id:Int, val retryExecutor: Executor):
    DataSource.Factory<Int, Review>() {

    val reviewsMutableLiveData = MutableLiveData<PageKeyedReviewsDataSource>()
    override fun create(): DataSource<Int, Review> {
        val reviewsDataSource = PageKeyedReviewsDataSource(id,retryExecutor)
        reviewsMutableLiveData.postValue(reviewsDataSource)
        return reviewsDataSource
    }

}