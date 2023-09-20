package com.safi.apps.clients.dost.weather.data.repository

import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow

class FavoritesRepositoryImpl : FavoritesRepository {
    override val favorites: Flow<List<City>>
        get() = TODO("Not yet implemented")

    override suspend fun addFavorite(city: City) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavorite(city: City) {
        TODO("Not yet implemented")
    }
}