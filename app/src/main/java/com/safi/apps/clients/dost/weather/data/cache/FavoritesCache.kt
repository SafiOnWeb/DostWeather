package com.safi.apps.clients.dost.weather.data.cache

import com.safi.apps.clients.dost.weather.data.model.City

interface FavoritesCache {
    suspend fun addCity(city: City)
    suspend fun removeCity(city: City)
}