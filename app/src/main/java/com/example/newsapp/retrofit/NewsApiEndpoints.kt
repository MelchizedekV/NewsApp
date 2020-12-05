package com.example.newsapp.retrofit

import com.example.newsapp.model.LatestNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiEndpoints {

   @GET("top-headlines")
   suspend fun getLatestNews(@Query("sources")sources:String,@Query("apiKey")apiKey:String):Response<LatestNews>

}