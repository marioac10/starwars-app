package com.example.starshipsacapp.ui.home.rvHome

sealed class Category(var isSelected:Boolean = true){
    object Starship : Category()
    object Planet : Category()
    object Specie : Category()
}
