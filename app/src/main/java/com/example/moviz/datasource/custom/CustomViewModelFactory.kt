package com.example.moviz.datasource.custom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviz.ui.reviews.ReviewsViewModel

class CustomViewModelFactory(private val id:Int):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReviewsViewModel(id) as T
    }
}