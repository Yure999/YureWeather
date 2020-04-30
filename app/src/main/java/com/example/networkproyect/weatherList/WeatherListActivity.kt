package com.example.networkproyect.weatherList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networkproyect.R
import com.example.networkproyect.data.model.Weather
import kotlinx.android.synthetic.main.activity_weather_list.*

class WeatherListActivity : AppCompatActivity(), WeatherListPresenter.View {

    private val presenter = WeatherListPresenter(this)
    private val adapter = WheatherListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        weatherList.layoutManager = LinearLayoutManager(this)
        weatherList.setHasFixedSize(true)
        weatherList.adapter = adapter

        weatherList.addItemDecoration(
            DividerItemDecoration(
                this,
                (weatherList.layoutManager as LinearLayoutManager).orientation
            )
        )
        presenter.init()
    }

    override fun showWeatherList(weatherList: List<Weather>) {
        adapter.addItems(weatherList)
    }
}
