package com.safi.apps.clients.dost.weather.data.repository

import com.safi.apps.clients.dost.weather.data.cache.FavoritesCache
import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow

class FavoritesRepositoryImpl(
    private val favoritesCache: FavoritesCache,
) : FavoritesRepository {
    override val favorites: Flow<List<City>> = favoritesCache.favorites

    override suspend fun addFavorite(city: City) = favoritesCache.addCity(city)

    override suspend fun removeFavorite(city: City) = favoritesCache.removeCity(city)
}