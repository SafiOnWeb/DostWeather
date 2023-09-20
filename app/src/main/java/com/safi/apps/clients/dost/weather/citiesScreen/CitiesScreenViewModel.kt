package com.safi.apps.clients.dost.weather.citiesScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safi.apps.clients.dost.weather.data.repository.WeatherRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CitiesScreenViewModel(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {
    private val cities = weatherRepository.cities
    val state = cities.map { cities ->
        CitiesScreenState(
            cities = cities
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        CitiesScreenState(
            cities = emptyList()
        )
    )
}