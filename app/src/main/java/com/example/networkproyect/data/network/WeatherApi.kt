package com.example.networkproyect.data.network

import com.example.networkproyect.data.model.Weather
import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("location/{id}")
    suspend fun getWeatherByLocation(@Path("id") id: String): WeatherResponse?
}

data class WeatherResponse(
    @SerializedName("consolidated_weather")
    val weatherList: List<Weather>
)


object WeatherApiFactory {
    fun get(): WeatherApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.metaweather.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(WeatherApi::class.java)
    }
}