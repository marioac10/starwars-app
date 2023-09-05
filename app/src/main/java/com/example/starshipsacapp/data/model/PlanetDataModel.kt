package com.example.starshipsacapp.data.model

import com.google.gson.annotations.SerializedName

data class PlanetDataModel(
    @SerializedName("next") val next:String,
    @SerializedName("results") val planets: List<PlanetItemModel>
)

data class PlanetItemModel(
    @SerializedName("name") val name:String,
    @SerializedName("climate")val climate:String,
    @SerializedName("gravity") val gravity:String,
    val urlImage:String
)
