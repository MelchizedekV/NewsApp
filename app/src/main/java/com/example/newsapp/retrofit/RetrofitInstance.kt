package com.example.newsapp.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {


    companion object{

        private val interceptor  = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val client  = OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(20,
            TimeUnit.SECONDS).build()


        val BASE_URL = "https://newsapi.org/v2/"

        fun getRetrofitInstance() : Retrofit {

            return Retrofit.Builder()

                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        }


    }



}