package com.fabricmonde.salesapp.tracemodel

import com.fabricmonde.salesapp.traceadapter.ViewType

data class Timepoint(val timepoint: String,
                     val description: String) : ViewType {

    override fun getViewType(): Int = ViewType.LINE

}
