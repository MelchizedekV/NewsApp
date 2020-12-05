package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.LatestNews
import com.example.newsapp.model.NewsRepositoryClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel :ViewModel() {


     private var mutableLiveData = MutableLiveData<LatestNews>()

     val latestNewsData:LiveData<LatestNews>
         get() = mutableLiveData

     lateinit var newsRepositoryClass: NewsRepositoryClass

       fun getApiValue(){
          newsRepositoryClass = NewsRepositoryClass()

           CoroutineScope(Dispatchers.Main).launch {
               mutableLiveData.value =newsRepositoryClass.getLatestNews()

           }

      }







}