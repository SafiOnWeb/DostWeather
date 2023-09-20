package com.safi.apps.clients.dost.weather.data.repository

import com.safi.apps.clients.dost.weather.data.api.WeatherApi
import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi
): WeatherRepository {
    override val cities: Flow<List<City>> = flow {
        emit(weatherApi.getCities())
    }
}