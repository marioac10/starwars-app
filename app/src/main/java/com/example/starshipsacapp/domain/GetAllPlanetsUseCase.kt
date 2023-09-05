package com.example.starshipsacapp.domain

import com.example.starshipsacapp.data.StarshipRepository
import com.example.starshipsacapp.data.model.PlanetDataModel

class GetAllPlanetsUseCase {
    private val repository = StarshipRepository()

    suspend operator fun invoke() : PlanetDataModel?{
        return repository.getAllPlanets()
    }
}