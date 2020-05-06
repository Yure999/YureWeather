package com.example.networkproyect.data.repository.remote

import android.accounts.NetworkErrorException
import com.example.networkproyect.data.model.Weather
import com.example.networkproyect.data.network.WeatherApiFactory
import java.lang.Exception

class RetrofitRemoteRepository : RemoteRepository{

    private val weatherApi = WeatherApiFactory.get()

    override suspend fun getWeatherListByLocation(locationId: String): List<Weather> {
        try {
            val response = weatherApi.getWeatherByLocation(locationId)
                ?: throw NetworkErrorException("Error fetching weather for location: $locationId")
            return response.weatherList
        }catch (e: Exception){
            throw NetworkErrorException("Error fetching weather")
        }

    }

}