package com.safi.apps.clients.dost.weather.favoriteCitiesScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safi.apps.clients.dost.weather.data.model.City
import com.safi.apps.clients.dost.weather.data.repository.FavoritesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoriteCitiesScreenViewModel(
    private val favoritesRepository: FavoritesRepository,
) : ViewModel() {
    private val favorites = favoritesRepository.favorites

    val state = favorites.map { favorites ->
        FavoriteCitiesScreenState(
            favorites = favorites,
            onAddFavoriteClick = this::onAddFavoriteClick,
            onRemoveFavoriteClick = this::onRemoveFavoriteClick
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        FavoriteCitiesScreenState()
    )

    private fun onAddFavoriteClick(city: City) {
        viewModelScope.launch { favoritesRepository.addFavorite(city) }
    }
    private fun onRemoveFavoriteClick(city: City) {
        viewModelScope.launch { favoritesRepository.removeFavorite(city) }
    }
}