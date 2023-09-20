package com.safi.apps.clients.dost.weather.data.api

import com.safi.apps.clients.dost.weather.data.model.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MockWeatherApi : WeatherApi {
    companion object {
        private val mockCities = listOf(
            City(id = "1", name = "Faisalabad"),
            City(id = "2", name = "Lahore"),
            City(id = "3", name = "Karachi"),
            City(id = "4", name = "Islamabad"),
            City(id = "5", name = "Rawalpindi"),
            City(id = "6", name = "Multan"),
            City(id = "7", name = "Gujranwala"),
            City(id = "8", name = "Peshawar"),
            City(id = "9", name = "Quetta"),
            City(id = "10", name = "Sialkot"),
            City(id = "11", name = "Bahawalpur"),
            City(id = "12", name = "Gujrat"),
            City(id = "13", name = "Sargodha"),
            City(id = "14", name = "Larkana"),
            City(id = "15", name = "Sukkur"),
            City(id = "16", name = "Sheikhupura"),
            City(id = "17", name = "Jhang"),
            City(id = "18", name = "Rahim Yar Khan"),
            City(id = "19", name = "Mardan"),
            City(id = "20", name = "Kasur"),
            City(id = "21", name = "Dera Ghazi Khan"),
            City(id = "22", name = "Nawabshah"),
            City(id = "23", name = "Mingora"),
            City(id = "24", name = "Okara"),
            City(id = "25", name = "Mirpur Khas"),
            City(id = "26", name = "Chiniot"),
            City(id = "27", name = "Kamoke"),
            City(id = "28", name = "Sadiqabad"),
            City(id = "29", name = "Burewala"),
            City(id = "30", name = "Jacobabad"),
            City(id = "31", name = "Muzaffargarh"),
            City(id = "32", name = "Muridke"),
            City(id = "33", name = "Jhelum"),
            City(id = "34", name = "Shikarpur"),
            City(id = "35", name = "Hafizabad"),
            City(id = "36", name = "Kohat"),
            City(id = "37", name = "Khanewal"),
            City(id = "38", name = "Dadu"),
            City(id = "39", name = "Gojra"),
            City(id = "40", name = "Mandi Bahauddin"),
            City(id = "41", name = "Tando Allahyar"),
            City(id = "42", name = "Daska"),
            City(id = "43", name = "Pakpattan"),
            City(id = "44", name = "Bahawalnagar"),
            City(id = "45", name = "Tando Adam"),
            City(id = "46", name = "Khairpur"),
            City(id = "47", name = "Chishtian"),
            City(id = "48", name = "Abbottabad"),
            City(id = "49", name = "Jaranwala"),
            City(id = "50", name = "Attock")
        )
    }

    override suspend fun getCities(): List<City> {
        return withContext(Dispatchers.IO) {
            // a network delay of 1 second
            delay(1000L)
            mockCities
        }
    }
}