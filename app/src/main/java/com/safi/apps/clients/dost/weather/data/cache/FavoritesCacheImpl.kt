package com.safi.apps.clients.dost.weather.data.cache

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

// Ideally, we should use some database like Room, but I am using SharedPrefs here to save the setup time
class FavoritesCacheImpl private constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson,
) : FavoritesCache {
    companion object {
        private const val FILE_NAME = "FAVORITES"
        private const val KEY_FAVORITES = "FAVORITES"
        fun newInstance(
            context: Context,
            gson: Gson,
        ): FavoritesCacheImpl {
            return FavoritesCacheImpl(
                sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE),
                gson = gson
            )
        }
    }

    private val _favorites = MutableStateFlow<List<City>>(emptyList())
    override val favorites: Flow<List<City>> = _favorites
    private fun getAll(): List<City> {
        return sharedPreferences.getString(KEY_FAVORITES, null)?.let {json ->
            gson.fromJson(json, object : TypeToken<List<City>>() {}.type)
        } ?: emptyList()
    }

    override suspend fun addCity(city: City) {
        val newItems = getAll() + city
        sharedPreferences.edit().apply {
            putString(KEY_FAVORITES, gson.toJson(newItems))
            apply()
        }
        _favorites.update { getAll() }
    }

    override suspend fun removeCity(city: City) {
        val newItems = getAll() - city
        sharedPreferences.edit().apply {
            putString(KEY_FAVORITES, gson.toJson(newItems))
            apply()
        }
        _favorites.update { getAll() }
    }
}