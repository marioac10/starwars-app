package com.example.starshipsacapp.ui.home.rvHome

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.R

class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)

    fun render(category: Category, onItemSelected: (Int) -> Unit) {
        val color = if(category.isSelected){
            R.color.starwar_bg_dialog
        }else{
            R.color.todo_background_disabled
        }

        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (category) {
            Category.Starship -> {
                tvCategoryName.text = "Starships"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.todo_starship_category
                    )
                )
            }
            Category.Specie-> {
                tvCategoryName.text = "Species"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.todo_specie_category
                    )
                )
            }
            Category.Planet -> {
                tvCategoryName.text = "Planets"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.todo_planet_category
                    )
                )
            }
        }

    }
}