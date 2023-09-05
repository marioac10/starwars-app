package com.example.starshipsacapp.data.network

import com.example.starshipsacapp.data.model.PlanetDataModel
import com.example.starshipsacapp.data.model.StarshipDataModel
import com.example.starshipsacapp.data.model.StarshipItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StarshipApiClient {
    @GET("starships/")
    suspend fun getAllStarships() : Response<StarshipDataModel>
    @GET("starships/{id}")
    suspend fun getStarshipDetail(@Path("id") starshipId : String) : Response<StarshipItemModel>
    @GET("planets/")
    suspend fun getAllPlanets() : Response<PlanetDataModel>
}