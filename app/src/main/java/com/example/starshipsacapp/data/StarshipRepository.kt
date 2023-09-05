package com.example.starshipsacapp.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.starshipsacapp.core.datastore
import com.example.starshipsacapp.data.model.PlanetDataModel
import com.example.starshipsacapp.data.model.StarshipDataModel
import com.example.starshipsacapp.data.model.StarshipDataStoreModel
import com.example.starshipsacapp.data.model.StarshipItemModel
import com.example.starshipsacapp.data.network.StarshipService
import kotlinx.coroutines.flow.map

class StarshipRepository{
    private val api = StarshipService()

    companion object{
        val ID = stringPreferencesKey("ID")
        val STARSHIP_NAME = stringPreferencesKey("STARSHIP_NAME")
        val STARSHIP_MODEL = stringPreferencesKey("STARSHIP_MODEL")
    }

    suspend fun getAllStarship() : StarshipDataModel?{
        val response : StarshipDataModel? = api.getAllStarships()
        return response
    }

    suspend fun getStarshipDetail(id:String) : StarshipItemModel?{
        val response : StarshipItemModel? = api.getStarshipDetail(id)
        return response
    }

    suspend fun getAllPlanets(): PlanetDataModel?{
        val response: PlanetDataModel? = api.getAllPlanets()
        return response
    }

    suspend fun saveStarshipDataStore(context: Context,starshipDataStoreModel: StarshipDataStoreModel){
        context.datastore.edit { preferences ->
            preferences[ID] = starshipDataStoreModel.id
            preferences[STARSHIP_NAME] =  starshipDataStoreModel.name
            preferences[STARSHIP_MODEL] = starshipDataStoreModel.model
        }
    }

    suspend fun getStarshipDataStore(context: Context) = context.datastore.data.map { preferences ->
        StarshipDataStoreModel(
            id = preferences[ID].orEmpty(),
            name = preferences[STARSHIP_NAME].orEmpty(),
            model = preferences[STARSHIP_MODEL].orEmpty()
        )
    }

}