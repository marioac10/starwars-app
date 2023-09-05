package com.example.starshipsacapp.ui.home.rvHome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.R

class CategoryAdapter(private val categories: List<Category>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }

    override fun getItemCount() = categories.size
}