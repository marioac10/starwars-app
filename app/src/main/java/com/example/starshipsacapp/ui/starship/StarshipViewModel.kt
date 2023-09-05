package com.example.starshipsacapp.ui.starship

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starshipsacapp.data.model.StarshipDataModel
import com.example.starshipsacapp.data.model.StarshipItemModel
import com.example.starshipsacapp.domain.GetAllStarshipsUseCase
import kotlinx.coroutines.launch


class StarshipViewModel: ViewModel() {

    val starshipList = MutableLiveData<List<StarshipItemModel>>()
    val isLoading = MutableLiveData<Boolean>()
    var getAllStarshipsUseCase = GetAllStarshipsUseCase()

    fun getAllStarshipsList(){
        isLoading.postValue(true)
        viewModelScope.launch {
            val result : StarshipDataModel? = getAllStarshipsUseCase()
            if(result != null){
                starshipList.postValue(result.starShips)
                isLoading.postValue(false)
            }
            isLoading.postValue(false)
        }
    }
}