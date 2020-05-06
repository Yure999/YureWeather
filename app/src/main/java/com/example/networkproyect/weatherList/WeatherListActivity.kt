package com.example.networkproyect.weatherList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        swipeRefresh.isRefreshing = true
        swipeRefresh.setOnRefreshListener {
            presenter.onRefresh()
        }
        presenter.init()
    }

    override fun showWeatherList(weatherData: List<Weather>) {
        adapter.addItems(weatherData)
        weatherList.visibility = View.VISIBLE
        swipeRefresh.isRefreshing = false
        loadingBar.visibility = View.GONE
        swipeRefresh.visibility = View.VISIBLE
    }

    override fun hideWeatherList() {
        weatherList.visibility = View.GONE
    }

    override fun showError(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        loadingBar.visibility = View.GONE
        swipeRefresh.visibility = View.VISIBLE
        swipeRefresh.isRefreshing = false
    }
}
