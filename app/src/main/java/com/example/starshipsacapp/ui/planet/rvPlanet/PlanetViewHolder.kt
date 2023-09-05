package com.example.starshipsacapp.ui.planet.rvPlanet

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.data.model.PlanetItemModel
import com.example.starshipsacapp.databinding.ItemPlanetBinding
import com.squareup.picasso.Picasso

class PlanetViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPlanetBinding.bind(view)

    val array = arrayOf(
        "https://static.wikia.nocookie.net/esstarwars/images/3/32/Hosra.png/revision/latest?cb=20180920170558",
        "https://static.wikia.nocookie.net/esstarwars/images/b/b6/UI_Planet_anoat.png/revision/latest?cb=20180415020001",
        "https://custom.swcombine.com/static/8/632-large-1675095606.png",
        "https://i.pinimg.com/originals/3f/f0/46/3ff046fc2053895ed1667916a85d863b.png",
        "https://custom.swcombine.com/static/8/4/34-13715-1558966795-large.png",
        "https://preview.redd.it/umbara-transparent-hd-planet-v0-lrbh9uwasf991.png?auto=webp&s=35c9c6a3ea1375e2ab81afaefd890b7d35cae593"
    )
    private val position = (0..5).random()

    fun render(planet : PlanetItemModel){
        val url:String = array[position]
        Picasso.get().load(url).into(binding.ivPlanet)
        binding.tvName.text = planet.name
        binding.tvClimate.text = planet.climate
        binding.tvGravity.text = planet.gravity
    }

}