package com.example.moviz.api

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {


    @GET("movie/{type}")
    fun getMovies(@Path("type") type:String,@Query("api_key") api_key:String,@Query("page") page:Int):Call<ResponseBody>

    @GET("movie/{movie_id}/reviews")
    fun getReviews(@Path("movie_id") movieId:Int,@Query("api_key") api_key:String,@Query("page") page:Int):Call<ResponseBody>





    companion object {
        private val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(httpUrl: HttpUrl): TmdbService {
            val okHttpClient = OkHttpClient.Builder()
                .build()
            return Retrofit.Builder()
                .baseUrl(httpUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(TmdbService::class.java)
        }


        fun create(): TmdbService = create(HttpUrl.parse(BASE_URL)!!)
    }
}