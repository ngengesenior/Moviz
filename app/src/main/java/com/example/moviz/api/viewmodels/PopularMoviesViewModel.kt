package com.example.moviz.api.viewmodels


/*
class PopularMoviesViewModel: ViewModel()
{

    var popularMoviesLiveData: LiveData<PagedList<Movie>>
    private val pageSize = 25
    val popularMoviesFactory:PageKeyMoviesFactory

    init {
        popularMoviesFactory = PageKeyMoviesFactory(TraktApiService.create(), Executor {

        })
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setPrefetchDistance(pageSize*2)
            .setEnablePlaceholders(true)
            .build()

        popularMoviesLiveData = LivePagedListBuilder<Int,Movie>(popularMoviesFactory,config).build()
    }


}*/


/*

class PopularMoviesViewModel: ViewModel()
{

    var popularMoviesLiveData: LiveData<PagedList<Movie>>
    private val pageSize = 25
    val popularMoviesFactory:PageKeyMoviesFactory

    init {
        popularMoviesFactory = PageKeyMoviesFactory(TmdbService.create(),"popular", Executor {

        })
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setPrefetchDistance(pageSize*2)
            .setEnablePlaceholders(true)
            .build()

        popularMoviesLiveData = LivePagedListBuilder<Int,Movie>(popularMoviesFactory,config).build()
    }


}
*/
