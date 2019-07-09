package com.example.moviz.adapter

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.example.moviz.data.Review
import com.example.moviz.ui.epoxy_views.LoadingViewModel_
import com.example.moviz.ui.epoxy_views.ReviewViewModel_

class ReviewsController :PagedListEpoxyController<Review>() {
    val endReached = false
    override fun buildItemModel(currentPosition: Int, item: Review?): EpoxyModel<*> {

        return if(item == null) {
            LoadingViewModel_()
                .id(-currentPosition)

        }  else {
            ReviewViewModel_()
                .id(currentPosition)
                .content(item.content)
                .author(item.author)
        }
    }

    override fun addModels(models: List<EpoxyModel<*>>) {
        super.addModels(models)
        LoadingViewModel_()
            .id("loading")
            .addIf(!endReached && models.isNotEmpty(),this)

    }
}