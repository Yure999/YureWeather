package com.example.networkproyect.weatherList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networkproyect.R
import com.example.networkproyect.data.model.Weather
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class WheatherListAdapter : RecyclerView.Adapter<WheatherListAdapter.WeatherViewHolder>() {

    private var weatherList: List<Weather> = emptyList()

    fun addItems(items: List<Weather>) {
        this.weatherList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = weatherList[position]
        holder.bind(weather)
    }

    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val stateImg = view.findViewById<ImageView>(R.id.stateImg)
        private val dateTxt = view.findViewById<TextView>(R.id.dateTxt)
        private val stateTxt = view.findViewById<TextView>(R.id.stateTxt)
        private val tempTxt = view.findViewById<TextView>(R.id.tempTxt)
        private val maxTempTxt = view.findViewById<TextView>(R.id.maxTempTxt)
        private val minTempTxt = view.findViewById<TextView>(R.id.minTempTxt)

        fun bind(weather: Weather) {
            with(weather) {

                Picasso.get()
                    .load("https://www.metaweather.com/static/img/weather/png/64/$icon.png")
                    .into(stateImg);
                dateTxt.text = date
                stateTxt.text = state
                tempTxt.text = temp.roundToInt().toString()
                maxTempTxt.text = maxTemp.roundToInt().toString()
                minTempTxt.text = minTemp.roundToInt().toString()
            }
        }

        companion object {
            fun from(parent: ViewGroup): WeatherViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.weather_item, parent, false)
                return WeatherViewHolder(view)
            }
        }
    }
}