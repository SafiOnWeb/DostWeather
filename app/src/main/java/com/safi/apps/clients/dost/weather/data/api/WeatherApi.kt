package com.safi.apps.clients.dost.weather.data.api

import com.safi.apps.clients.dost.weather.data.model.City

interface WeatherApi {
    suspend fun getCities(): List<City>
}