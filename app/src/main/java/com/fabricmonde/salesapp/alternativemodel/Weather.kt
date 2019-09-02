package com.fabricmonde.salesapp.alternativemodel

import com.fabricmonde.salesapp.alternativeadapter.ViewType


class Weather(val date: String,
              val weatherDescription: String,
              val temperature: Float,
              val isLastItem: Boolean = false) : ViewType {

    override fun getViewType(): Int  = ViewType.ITEM

}
