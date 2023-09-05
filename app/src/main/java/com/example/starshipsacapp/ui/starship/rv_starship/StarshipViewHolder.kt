package com.example.starshipsacapp.ui.starship.rv_starship

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.data.model.StarshipItemModel
import com.example.starshipsacapp.databinding.ItemStarshipBinding
import com.squareup.picasso.Picasso

class StarshipViewHolder(view : View) : RecyclerView.ViewHolder(view){
    private val binding = ItemStarshipBinding.bind(view)

    val array = arrayOf(
        "https://i.pinimg.com/originals/69/ac/cb/69accb715861ab8f6941284fd8e4c978.png",
        "https://assets.stickpng.com/images/580b585b2edbce24c47b2d2c.png",
        "https://i.pinimg.com/originals/5c/67/f7/5c67f74cdf88d9da3b047d4a8045e2f4.png",
        "https://i.pinimg.com/originals/60/0f/c6/600fc6196f62e5c7a7f3f34514e3ac26.png",
        "https://i.pinimg.com/originals/15/df/83/15df83af21e2c7ac91a2263a03cd25bb.png",
        "https://i.pinimg.com/originals/62/8d/84/628d84d2b0ec4033cacafe1d7232ca35.png",
        "https://i.pinimg.com/originals/ad/72/3b/ad723b5f99d595151fad82b7cc385030.png"
    )
    private val position = (0..6).random()

    fun bind(item: StarshipItemModel, onItemSelected:(String, String)->Unit){
        val urlItems = item.url.split("/")
        val id = urlItems[urlItems.size-2]

        val url:String = array[position]
        Picasso.get().load(url).into(binding.ivStarship)
        binding.tvStarshipName.text = item.name
        binding.tvStarshipModelo.text = item.model
        binding.root.setOnClickListener {
            onItemSelected(id,url)
        }
    }

}