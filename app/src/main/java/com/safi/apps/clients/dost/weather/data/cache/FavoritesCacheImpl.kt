package com.safi.apps.clients.dost.weather.data.cache

import com.safi.apps.clients.dost.weather.data.model.City

// Ideally, we should use some database like Room, but I am using SharedPrefs here to save the setup time
class FavoritesCacheImpl: FavoritesCache {
    override suspend fun addCity(city: City) {
        TODO("Not yet implemented")
    }

    override suspend fun removeCity(city: City) {
        TODO("Not yet implemented")
    }
}