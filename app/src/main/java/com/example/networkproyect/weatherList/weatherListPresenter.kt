package com.example.networkproyect.weatherList


import com.example.networkproyect.data.model.Weather
import com.example.networkproyect.data.network.WeatherApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherListPresenter(private val view : View){

    private val weatherApi = WeatherApiFactory.get()

    fun init(){
        CoroutineScope(Dispatchers.Main).launch{
            val weatherResponse = withContext(Dispatchers.IO){
                weatherApi.getWeatherByLocation("766273")
            }
            view.showWeatherList(weatherResponse.weatherList)
        }
    }

    interface View{
        fun showWeatherList(weatherList : List<Weather>)
    }
}