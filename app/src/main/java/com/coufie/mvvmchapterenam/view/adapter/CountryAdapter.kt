package com.coufie.mvvmchapterenam.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coufie.mvvmchapterenam.R
import com.coufie.mvvmchapterenam.model.getAllCountryItem
import kotlinx.android.synthetic.main.item_countries.view.*

class CountryAdapter() : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    private var countryData : List<getAllCountryItem>? = null

    fun setCountryList(countryList : List<getAllCountryItem>){
        this.countryData = countryList
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val uiCountry = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_countries, parent, false)

        return  ViewHolder(uiCountry)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.itemView.tv_countryname.text = "Name : ${countryData!![position].name}"
        holder.itemView.tv_countrycapital.text = "Capital : ${countryData!![position].capital}"
        holder.itemView.tv_countryregion.text = "Region : ${countryData!![position].region}"
        holder.itemView.tv_countrypopulation.text = "Population : ${countryData!![position].population.toString()}"
        holder.itemView.tv_countrytimezones.text = "Timezones : ${countryData!![position].timezones.toString()}"


        this.let {
            Glide.with(holder.itemView.context).load(countryData!![position].flags.png).into(holder.itemView.iv_countryimage)
        }
    }

    override fun getItemCount(): Int {
        if(countryData == null){
            return 0
        }else{
            return countryData!!.size
        }
    }
}