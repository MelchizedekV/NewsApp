package com.example.newsapp.model

data class LatestNews(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)