package com.fabricmonde.salesapp.tracemodel

import com.fabricmonde.salesapp.traceadapter.ViewType


data class CityWeather(val city: String,
                       val weatherDescription: String,
                       val temperature: Float,
                       val rainPercentage: String,
                       val cloudyPercentage: String,
                       val windSpeed: String) : ViewType {

    override fun getViewType(): Int = ViewType.HEADER

}
