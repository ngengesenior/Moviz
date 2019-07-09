package com.example.moviz.utils

import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyController
import com.example.moviz.api.TmdbService
import com.example.moviz.data.*
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import org.json.JSONObject

val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

fun parseStringToMoviesData(jsonString:String): MovieListingData {


    val jsonObject = JSONObject(jsonString)
    val movies:List<Movie> = gson.fromJson(jsonObject.getJSONArray("results").toString(),object :TypeToken<List<Movie>>(){}.type)
    val totalPages:Int = gson.fromJson(jsonObject.getInt("total_pages").toString(),object : TypeToken<Int>(){}.type)
    val currentPage:Int = gson.fromJson(jsonObject.getInt("page").toString(),object : TypeToken<Int>(){}.type)
    return MovieListingData(movies,currentPage,totalPages)


}


fun parseStringToReviewsData(jsonString: String):ReviewsListing {
    val jsonObject = JSONObject(jsonString)
    val reviews:List<Review> = gson.fromJson(jsonObject.getJSONArray("results").toString(),object :TypeToken<List<Review>>(){}.type)
    val totalPages:Int = gson.fromJson(jsonObject.getInt("total_pages").toString(),object : TypeToken<Int>(){}.type)
    val currentPage:Int = gson.fromJson(jsonObject.getInt("page").toString(),object : TypeToken<Int>(){}.type)

    return ReviewsListing(reviews,currentPage,totalPages)

}

fun RecyclerView.setupGridManager(epoxyController: EpoxyController) {
    val spanCount = 2
    val manager = GridLayoutManager(this.context,spanCount)
    epoxyController.spanCount = spanCount
    manager.spanSizeLookup = epoxyController.spanSizeLookup
    this.layoutManager = manager
    this.adapter = epoxyController.adapter
}


fun ImageView.loadTmdbImage(url:String?) {
    Picasso.get()
        .load("https://image.tmdb.org/t/p/w500$url")
        .into(this)

}

fun getAppendedString(idsList:List<ID>):java.lang.StringBuilder {
    val genreString = StringBuilder()
    val lastIndex = idsList.lastIndex
    idsList.mapIndexed {index,value ->
        if (index !=lastIndex) {
            genreString.append("$value,")
        }
        else genreString.append(value)


    }
    return genreString
}