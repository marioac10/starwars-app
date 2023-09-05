package com.example.starshipsacapp.data.network

import com.example.starshipsacapp.core.RetrofitHelper
import com.example.starshipsacapp.data.model.PlanetDataModel
import com.example.starshipsacapp.data.model.StarshipDataModel
import com.example.starshipsacapp.data.model.StarshipItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StarshipService{
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllStarships() : StarshipDataModel?{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(StarshipApiClient::class.java).getAllStarships()
            response.body()
        }
    }

    suspend fun  getStarshipDetail(id:String) : StarshipItemModel?{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(StarshipApiClient::class.java).getStarshipDetail(starshipId = id)
            response.body()
        }
    }

    suspend fun getAllPlanets(): PlanetDataModel?{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(StarshipApiClient::class.java).getAllPlanets()
            response.body()
        }
    }
}