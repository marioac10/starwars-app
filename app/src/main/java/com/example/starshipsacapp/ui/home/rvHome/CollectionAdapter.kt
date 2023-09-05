package com.example.starshipsacapp.ui.home.rvHome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starshipsacapp.R

class CollectionAdapter(var itemsCollection: List<ItemCollection>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CollectionViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_collection, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.render(itemsCollection[position])
        holder.itemView.setOnClickListener{ onTaskSelected(position) }

    }

    override fun getItemCount() = itemsCollection.size
}