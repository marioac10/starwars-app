package com.example.starshipsacapp.ui.home.rvHome

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.R

class CollectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCollection: TextView = view.findViewById(R.id.tvCollection)
    private val cbCollection: CheckBox = view.findViewById(R.id.cbCollection)

    fun render(itemCollection: ItemCollection){

        if(itemCollection.isSelected){
            tvCollection.paintFlags = tvCollection.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvCollection.paintFlags = tvCollection.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        cbCollection.isChecked = itemCollection.isSelected

        val color = when(itemCollection.category){
            Category.Starship -> R.color.todo_starship_category
            Category.Specie -> R.color.todo_specie_category
            Category.Planet -> R.color.todo_planet_category
        }
        cbCollection.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbCollection.context, color)
        )

        tvCollection.text = itemCollection.name
    }
}