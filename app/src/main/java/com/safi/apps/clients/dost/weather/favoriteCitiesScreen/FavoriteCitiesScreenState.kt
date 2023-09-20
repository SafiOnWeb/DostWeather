package com.safi.apps.clients.dost.weather.favoriteCitiesScreen

import com.safi.apps.clients.dost.weather.data.model.City

data class FavoriteCitiesScreenState(
    val favorites: List<City> = emptyList(),
    val onAddFavoriteClick: (City) -> Unit = {},
    val onRemoveFavoriteClick: (City) -> Unit = {},
)