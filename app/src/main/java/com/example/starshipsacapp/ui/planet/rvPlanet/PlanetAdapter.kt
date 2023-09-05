package com.example.starshipsacapp.ui.planet.rvPlanet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.R
import com.example.starshipsacapp.data.model.PlanetItemModel

class PlanetAdapter(private var planets : List<PlanetItemModel> = emptyList())
    :RecyclerView.Adapter<PlanetViewHolder>() {

    fun setPlanetsList(planetsList: List<PlanetItemModel>) {
        this.planets = planetsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planet, parent, false)
        return PlanetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.render(planets[position])
    }

    override fun getItemCount(): Int {
        return planets.size
    }
}