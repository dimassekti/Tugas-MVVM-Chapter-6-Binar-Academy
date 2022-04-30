package com.coufie.mvvmchapterenam.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coufie.mvvmchapterenam.R
import com.coufie.mvvmchapterenam.model.getAllNewsItem
import kotlinx.android.synthetic.main.item_news.view.*


class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var newsData : List<getAllNewsItem>? = null

    fun setNewsList(newsList : List<getAllNewsItem>){
        this.newsData = newsList
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val UiNews = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news , parent, false)

        return ViewHolder(UiNews)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_title.text = newsData!![position].title
        holder.itemView.tv_createdAt.text = newsData!![position].createdAt
        holder.itemView.tv_author.text = newsData!![position].author

        this.let {
            Glide.with(holder.itemView.context).load(newsData!![position].image).into(holder.itemView.iv_image)
        }

    }

    override fun getItemCount(): Int {
        if(newsData == null){
            return 0
        }else{
            return newsData!!.size
        }
    }

}