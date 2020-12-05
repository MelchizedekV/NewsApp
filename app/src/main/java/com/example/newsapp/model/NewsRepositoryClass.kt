package com.example.newsapp.model

import android.util.Log
import com.example.newsapp.R
import com.example.newsapp.common.Constants
import com.example.newsapp.retrofit.NewsApiEndpoints
import com.example.newsapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsRepositoryClass {


    lateinit var latestNewsResponse :LatestNews

    suspend fun getLatestNews():LatestNews{

        val response = RetrofitInstance.getRetrofitInstance().create(NewsApiEndpoints::class.java)


        coroutineScope {
            launch(Dispatchers.IO) {

                latestNewsResponse= response.getLatestNews("bbc-news",Constants.LatestNewsApiKey).body()!!
            }
        }


        return latestNewsResponse
    }
}