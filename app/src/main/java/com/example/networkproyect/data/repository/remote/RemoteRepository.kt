package com.example.networkproyect.data.repository.remote

import com.example.networkproyect.data.model.Weather

interface RemoteRepository {
    suspend fun getWeatherListByLocation(locationId: String): List<Weather>
}