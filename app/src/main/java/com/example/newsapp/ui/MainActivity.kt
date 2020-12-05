package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapters.LatestNewsAdapter
import com.example.newsapp.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel :NewsViewModel

    lateinit var latestNewsAdapter:LatestNewsAdapter
    private lateinit var latest_news_list:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        latest_news_list =findViewById(R.id.latest_news_list)
        callNewsApi()


        viewModel.latestNewsData.observe(this, Observer {

            latestNewsAdapter = LatestNewsAdapter(it,this)

            latest_news_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            latest_news_list.adapter =latestNewsAdapter


        })

    }



    private fun callNewsApi() {
        viewModel.getApiValue()
    }


}