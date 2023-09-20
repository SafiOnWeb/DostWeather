package com.safi.apps.clients.dost.weather.data.repository

import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    val cities: Flow<List<City>>
}