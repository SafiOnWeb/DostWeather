package com.safi.apps.clients.dost.weather.citiesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.safi.apps.clients.dost.weather.data.model.City
import org.koin.androidx.compose.getViewModel

@Composable
fun CityPicker(
    modifier: Modifier = Modifier,
    onClick: (City) -> Unit,
    viewModel: CitiesScreenViewModel = getViewModel(),
) {
    val state by viewModel.state.collectAsState()
    if (state.cities.isEmpty()) {
        CircularProgressIndicator()
    } else {
        CityPicker(
            modifier = modifier,
            state = state,
            onClick = onClick
        )
    }
}

@Composable
private fun CityPicker(
    modifier: Modifier = Modifier,
    state: CitiesScreenState,
    onClick: (City) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(state.cities) { city ->
            CityItem(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .clickable { onClick(city) },
                city = city
            )
        }
    }
}

@Composable
private fun CityItem(
    modifier: Modifier = Modifier,
    city: City,
) {
    Text(
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp),
        text = city.name,
        color = MaterialTheme.colorScheme.onPrimaryContainer
    )
}