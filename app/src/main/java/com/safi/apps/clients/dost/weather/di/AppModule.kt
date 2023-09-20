package com.safi.apps.clients.dost.weather.di

import com.google.gson.Gson
import com.safi.apps.clients.dost.weather.data.api.MockWeatherApi
import com.safi.apps.clients.dost.weather.data.api.WeatherApi
import com.safi.apps.clients.dost.weather.data.cache.FavoritesCache
import com.safi.apps.clients.dost.weather.data.cache.FavoritesCacheImpl
import com.safi.apps.clients.dost.weather.data.repository.FavoritesRepository
import com.safi.apps.clients.dost.weather.data.repository.FavoritesRepositoryImpl
import com.safi.apps.clients.dost.weather.data.repository.WeatherRepository
import com.safi.apps.clients.dost.weather.data.repository.WeatherRepositoryImpl
import com.safi.apps.clients.dost.weather.favoriteCitiesScreen.FavoriteCitiesScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Gson
    factory { Gson() }
    // API
    factory<WeatherApi> { MockWeatherApi() }
    // Cache
    factory<FavoritesCache> {
        FavoritesCacheImpl.newInstance(
            context = androidContext(),
            gson = get()
        )
    }
    // Repository
    factory<WeatherRepository> { WeatherRepositoryImpl() }
    factory<FavoritesRepository> {
        FavoritesRepositoryImpl(
            favoritesCache = get()
        )
    }
    // ViewModel
    viewModel {
        FavoriteCitiesScreenViewModel(
            favoritesRepository = get()
        )
    }
}