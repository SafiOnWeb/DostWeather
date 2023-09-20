package com.safi.apps.clients.dost.weather.data.cache

import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow

interface FavoritesCache {
    val favorites: Flow<List<City>>
    suspend fun addCity(city: City)
    suspend fun removeCity(city: City)
}