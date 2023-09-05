package com.example.starshipsacapp.ui.starship

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starshipsacapp.data.StarshipRepository
import com.example.starshipsacapp.data.model.StarshipDataStoreModel
import com.example.starshipsacapp.data.model.StarshipItemModel
import com.example.starshipsacapp.domain.GetStarshipDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StarshipDetailViewModel : ViewModel() {
    val starshipDetail = MutableLiveData<StarshipItemModel?>()
    val isLoading = MutableLiveData<Boolean>()
    var starshipDataStore = MutableLiveData<StarshipDataStoreModel>()
    var getStarshipDetailUseCase = GetStarshipDetailUseCase()
    private var repository = StarshipRepository()


    fun getStarshipDetail(id:String) {
        isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            val result : StarshipItemModel? = getStarshipDetailUseCase(id)
            if (result != null){
                starshipDetail.postValue(result)
                isLoading.postValue(false)
            }
            isLoading.postValue(false)
        }
    }

    fun saveData(context: Context,dataStarship: StarshipDataStoreModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveStarshipDataStore(
                context,
                StarshipDataStoreModel(
                    id = dataStarship.id,
                    name = dataStarship.name,
                    model = dataStarship.model
                )
            )
        }
    }

    fun retrieveData(context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getStarshipDataStore(context).collect{
                starshipDataStore.postValue(it)
            }
        }
    }

}