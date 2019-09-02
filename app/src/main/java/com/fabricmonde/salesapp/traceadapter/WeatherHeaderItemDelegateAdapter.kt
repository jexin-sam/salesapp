package com.fabricmonde.salesapp.traceadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.fabricmonde.salesapp.R
import com.fabricmonde.salesapp.tracemodel.CityWeather
import kotlinx.android.synthetic.main.item_trace_weather_header.view.*
import kotlinx.android.synthetic.main.item_trace_weather_header.view.temperature_degree
import kotlinx.android.synthetic.main.item_trace_weather_header.view.weather_description


class WeatherHeaderItemDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): androidx.recyclerview.widget.RecyclerView.ViewHolder = WeatherItemViewHolder(parent)

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, item: ViewType) {
        holder as WeatherItemViewHolder
        holder.bind(item as CityWeather)
    }

    inner class WeatherItemViewHolder(parent: ViewGroup) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_trace_weather_header, parent, false)) {

        fun bind(item: CityWeather) = with(itemView) {
            city.text = item.city
            weather_description.text = item.weatherDescription
            temperature_degree.text = "${item.temperature}\u00b0"
            rain_percentage.text = item.rainPercentage
            cloud_percentage.text = item.cloudyPercentage
            wind_speed.text = item.windSpeed

        }

    }

}
