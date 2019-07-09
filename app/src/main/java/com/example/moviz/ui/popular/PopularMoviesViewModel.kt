package com.example.moviz.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviz.api.TmdbService
import com.example.moviz.data.Movie
import com.example.moviz.datasource.PageKeyMoviesFactory
import java.util.concurrent.Executor

class PopularMoviesViewModel: ViewModel()
{

    var popularMoviesLiveData: LiveData<PagedList<Movie>>
    private val pageSize = 25
    private val popularMoviesFactory: PageKeyMoviesFactory = PageKeyMoviesFactory(TmdbService.create(), "popular", Executor {

    })

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(5)
            .setEnablePlaceholders(false)
            .build()

        popularMoviesLiveData = LivePagedListBuilder(popularMoviesFactory,config).build()

    }







}
