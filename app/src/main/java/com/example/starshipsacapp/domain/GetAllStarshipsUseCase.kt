package com.example.starshipsacapp.domain

import com.example.starshipsacapp.data.StarshipRepository
import com.example.starshipsacapp.data.model.StarshipDataModel

class GetAllStarshipsUseCase{
    private val repository = StarshipRepository()

    suspend operator fun invoke() : StarshipDataModel?{
        return repository.getAllStarship()
    }
}