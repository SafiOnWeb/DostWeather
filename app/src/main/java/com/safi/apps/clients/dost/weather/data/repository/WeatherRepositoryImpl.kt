package com.safi.apps.clients.dost.weather.data.repository

import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow

class WeatherRepositoryImpl: WeatherRepository {
    override val cities: Flow<List<City>>
            get() = TODO("Not yet implemented")
}