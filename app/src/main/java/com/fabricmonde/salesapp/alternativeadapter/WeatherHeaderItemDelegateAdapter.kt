package com.fabricmonde.salesapp.alternativeadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fabricmonde.salesapp.R
import com.fabricmonde.salesapp.alternativemodel.CityWeather
import kotlinx.android.synthetic.main.item_alternative_weather.view.*
import kotlinx.android.synthetic.main.item_alternative_weather_header.view.*
import kotlinx.android.synthetic.main.item_alternative_weather_header.view.temperature_degree
import kotlinx.android.synthetic.main.item_alternative_weather_header.view.weather_description
import pl.hypeapp.materialtimelineview.MaterialTimelineView


class WeatherHeaderItemDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = WeatherItemViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as WeatherItemViewHolder
        holder.bind(item as CityWeather)
    }

    inner class WeatherItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_alternative_weather_header, parent, false)) {

        fun bind(item: CityWeather) = with(itemView) {

            if (item.isLastItem) {
               item_alternative_weather.position = MaterialTimelineView.POSITION_LAST
            }
            else if(item.isFirstItem)
            {
                item_alternative_weather.position = MaterialTimelineView.POSITION_FIRST
            }

            city.text = item.city
            weather_description.text = item.weatherDescription
            temperature_degree.text = "${item.temperature}\u00b0"
            rain_percentage.text = item.rainPercentage
            cloud_percentage.text = item.cloudyPercentage
            wind_speed.text = item.windSpeed
        }

    }

}
