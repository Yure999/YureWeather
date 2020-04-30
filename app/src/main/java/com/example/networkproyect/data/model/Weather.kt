package com.example.networkproyect.data.model

import com.google.gson.annotations.SerializedName

data class Weather(
    val id: Long,
    @SerializedName("weather_state_name")
    val state: String,
    @SerializedName("weather_state_abbr")
    val icon: String,
    @SerializedName("applicable_date")
    val date: String,
    @SerializedName("the_temp")
    val temp: Float,
    @SerializedName("max_temp")
    val maxTemp: Float,
    @SerializedName("min_temp")
    val minTemp: Float
)


