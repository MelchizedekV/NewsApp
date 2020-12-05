package com.example.newsapp.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.Article
import com.example.newsapp.model.LatestNews
import com.example.newsapp.ui.MainActivity
import com.squareup.picasso.Picasso


class LatestNewsAdapter(
    latestNews: LatestNews,
    mainActivity: MainActivity
) : RecyclerView.Adapter<LatestNewsAdapter.ViewHolder>() {

     var latestNewsList: List<Article> = latestNews.articles
     private val context =mainActivity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.latestnews_single_layout, parent, false)
        return ViewHolder(v)
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {

         holder.title.text = latestNewsList[position].title
         holder.desc.text= latestNewsList[position].description
         holder.author.text =latestNewsList[position].author
         Picasso.get().load(latestNewsList[position].urlToImage).resize(250,250).into(holder.news_img);

         holder.newsLayout.setOnClickListener {

                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(latestNewsList[position].url))
                context.startActivity(browserIntent)
         }
     }

     override fun getItemCount(): Int {
        return latestNewsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById(R.id.title_txt) as TextView
        val desc  = itemView.findViewById(R.id.desc_txt) as TextView
        val author  = itemView.findViewById(R.id.author_txt) as TextView
        val news_img  = itemView.findViewById(R.id.news_img) as ImageView
        val newsLayout=itemView.findViewById(R.id.newsLayout) as ConstraintLayout




    }


}