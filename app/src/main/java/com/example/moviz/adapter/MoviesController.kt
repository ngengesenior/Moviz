package com.example.moviz.adapter

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.example.moviz.data.Movie
import com.example.moviz.ui.epoxy_views.LoadingViewModel_
import com.example.moviz.ui.epoxy_views.MovieViewModel_

class MoviesController(private val listener:MovieClickListener) :PagedListEpoxyController<Movie>(){
    val endReached = false
    override fun buildItemModel(currentPosition: Int, item: Movie?): EpoxyModel<*> {
        return if (item ==null) {
            LoadingViewModel_()
                .id(-currentPosition)
        } else {

            MovieViewModel_()
                .id(currentPosition)
                .image(item.poster_path)
                .movieItemClickListener { _, _, _, _ ->
                    listener.onMovieItemClicked(item)
                }

        }

    }

    override fun addModels(models: List<EpoxyModel<*>>) {
        super.addModels(models)
        LoadingViewModel_()
            .id("loading")
            .addIf(!endReached && models.isNotEmpty(),this)

    }


}

interface MovieClickListener {
    fun onMovieItemClicked(movie: Movie)

}