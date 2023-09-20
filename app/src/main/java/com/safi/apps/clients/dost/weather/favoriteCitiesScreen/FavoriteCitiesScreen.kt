package com.safi.apps.clients.dost.weather.favoriteCitiesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.safi.apps.clients.dost.weather.citiesScreen.CityPicker
import com.safi.apps.clients.dost.weather.data.model.City
import com.safi.apps.clients.dost.weather.ui.theme.WeatherAppTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteCitiesScreen(
    viewModel: FavoriteCitiesScreenViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()
    WeatherAppTheme {
        FavoriteCitiesScreen(
            state = state,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun FavoriteCitiesScreen(
    state: FavoriteCitiesScreenState,
) {
    var showCityPicker by rememberSaveable() {
        mutableStateOf(false)
    }
    if (showCityPicker) {
        Dialog(
            onDismissRequest = { showCityPicker = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Surface(
                shape = MaterialTheme.shapes.extraLarge
            ) {
                CityPicker(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    onClick = { city ->
                        showCityPicker = false
                        state.onAddFavoriteClick(city)
                    },
                )
            }
        }
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showCityPicker = true }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Favorites",
                    style = MaterialTheme.typography.headlineLarge
                )
                if (state.favorites.isEmpty()) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No favorite cities yet. Please add some."
                        )
                    }
                } else {
                    FavoritesList(
                        modifier = Modifier,
                        favorites = state.favorites
                    )
                }
            }
        }
    }
}

@Composable
private fun FavoritesList(
    modifier: Modifier,
    favorites: List<City>,
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(favorites) { city ->
            Text(text = city.name)
        }
    }
}