package com.example.starshipsacapp.data.model

import com.google.gson.annotations.SerializedName

data class StarshipDataModel(
    @SerializedName("next") val next:String,
    @SerializedName("results") val starShips: List<StarshipItemModel>
)

data class StarshipItemModel(
    @SerializedName("name") val name:String,
    @SerializedName("model")val model:String,
    @SerializedName("url") val url:String,
    @SerializedName("manufacturer") val manufacturer:String,
    @SerializedName("length") val length:String,
    @SerializedName("crew") val crew:String,
    @SerializedName("passengers") val passengers:String,
    @SerializedName("max_atmosphering_speed") val max_atmosphering_speed:String,
    @SerializedName("cost_in_credits") val cost_in_credits:String,
    @SerializedName("consumables") val consumables:String,
    @SerializedName("starship_class") val starship_class:String,
    @SerializedName("hyperdrive_rating") val hyperdrive_rating:String,
    val urlImage:String
)
