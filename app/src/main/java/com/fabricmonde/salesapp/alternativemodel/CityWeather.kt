package com.fabricmonde.salesapp.alternativemodel

import com.fabricmonde.salesapp.alternativeadapter.ViewType


data class CityWeather(val city: String,
                       val weatherDescription: String,
                       val temperature: Float,
                       val rainPercentage: String,
                       val cloudyPercentage: String,
                       val windSpeed: String,
                       val isLastItem: Boolean = false,
                       val isFirstItem: Boolean = false) : ViewType {

    override fun getViewType(): Int = ViewType.HEADER

}
