package com.example.moviz.datasource
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.Executor
import androidx.paging.DataSource
import com.example.moviz.api.TmdbService
import com.example.moviz.data.Movie




class PageKeyMoviesFactory(val tmdbService: TmdbService,val type:String, val retryExecutor:Executor):DataSource.Factory<Int, Movie>() {

    val popularMoviesMutableData = MutableLiveData<PageKeyedMoviesDataSource>()
    override fun create(): DataSource<Int, Movie> {
        val moviesDataSource = PageKeyedMoviesDataSource(tmdbService,type,retryExecutor)
        popularMoviesMutableData.postValue(moviesDataSource)
        return moviesDataSource
    }

}
