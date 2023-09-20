package com.safi.apps.clients.dost.weather.data.repository

import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    val favorites: Flow<List<City>>
    suspend fun addFavorite(city: City)
    suspend fun removeFavorite(city: City)
}