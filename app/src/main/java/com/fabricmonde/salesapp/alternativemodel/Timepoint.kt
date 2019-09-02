package com.fabricmonde.salesapp.alternativemodel

import com.fabricmonde.salesapp.alternativeadapter.ViewType

data class Timepoint(val timepoint: String,
                     val description: String) : ViewType {

    override fun getViewType(): Int = ViewType.LINE

}
