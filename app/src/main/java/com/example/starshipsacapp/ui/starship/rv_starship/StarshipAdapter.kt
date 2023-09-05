package com.example.starshipsacapp.ui.starship.rv_starship

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.R
import com.example.starshipsacapp.data.model.StarshipItemModel

class StarshipAdapter(
    var Starships : List<StarshipItemModel> = emptyList(),
    private val onItemSelected:(String,String) -> Unit
) : RecyclerView.Adapter<StarshipViewHolder>(){

    fun setStarshipList(starshipList: List<StarshipItemModel>) {
        this.Starships = starshipList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StarshipViewHolder(layoutInflater.inflate(R.layout.item_starship, parent, false))
    }

    override fun getItemCount(): Int {
        return Starships.size
    }

    override fun onBindViewHolder(holder: StarshipViewHolder, position: Int) {
        val item = Starships[position]
        holder.bind(item, onItemSelected)
    }

}