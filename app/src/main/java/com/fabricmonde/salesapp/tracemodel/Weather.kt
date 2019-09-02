package com.fabricmonde.salesapp.tracemodel

import com.fabricmonde.salesapp.traceadapter.ViewType

class Weather(val position : Int,
              val weatherDescription: String,
              val temperature: Float,
              val isLastItem: Boolean = false) : ViewType {

    override fun getViewType(): Int  = ViewType.ITEM


}
