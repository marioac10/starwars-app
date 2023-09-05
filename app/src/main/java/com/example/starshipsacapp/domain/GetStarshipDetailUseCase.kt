package com.example.starshipsacapp.domain

import com.example.starshipsacapp.data.StarshipRepository
import com.example.starshipsacapp.data.model.StarshipItemModel

class GetStarshipDetailUseCase(
    private val id: String = ""
) {
    private val repository = StarshipRepository()

    suspend operator fun invoke(id:String) : StarshipItemModel?{
        return repository.getStarshipDetail(id = id)
    }
}