package com.safi.apps.clients.dost.weather.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.safi.apps.clients.dost.weather.citiesScreen.CitiesScreen
import com.safi.apps.clients.dost.weather.favoriteCitiesScreen.FavoriteCitiesScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.FAVORITES.route
    ) {
        composable(route = MainScreen.FAVORITES.route) {
            FavoriteCitiesScreen()
        }
        composable(route = MainScreen.CITIES.route) {
            CitiesScreen()
        }
    }
}
