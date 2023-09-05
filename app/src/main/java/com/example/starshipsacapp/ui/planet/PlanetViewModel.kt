package com.example.starshipsacapp.ui.planet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starshipsacapp.data.model.PlanetDataModel
import com.example.starshipsacapp.data.model.PlanetItemModel
import com.example.starshipsacapp.domain.GetAllPlanetsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanetViewModel : ViewModel() {
    val planets = MutableLiveData<List<PlanetItemModel>>()
    val isLoading = MutableLiveData<Boolean>()
    val getAllPlanetsUseCase = GetAllPlanetsUseCase()

    fun getAllPlanets(){
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            val result : PlanetDataModel? = getAllPlanetsUseCase()
            if (result != null)
            {
                planets.postValue(result.planets)
                isLoading.postValue(false)
            }
            isLoading.postValue(false)
        }
    }

}