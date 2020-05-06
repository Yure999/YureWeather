package com.example.networkproyect.weatherList


import android.accounts.NetworkErrorException
import com.example.networkproyect.data.model.Weather
import com.example.networkproyect.data.repository.remote.RemoteRepository
import com.example.networkproyect.data.repository.remote.RetrofitRemoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.NetPermission

class WeatherListPresenter(private val view : View){

    private val remoteRepository: RemoteRepository = RetrofitRemoteRepository()

    fun init(){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                val weatherList = withContext(Dispatchers.IO){
                    remoteRepository.getWeatherListByLocation("766273")
                }
                view.showWeatherList(weatherList)
            }catch (e: NetworkErrorException){
                view.showError(e.message!!)
            }

        }
    }

    fun onRefresh(){
        view.hideWeatherList()
        init()
    }

    interface View{
        fun showWeatherList(weatherData : List<Weather>)
        fun hideWeatherList()
        fun showError(message: String)
    }
}