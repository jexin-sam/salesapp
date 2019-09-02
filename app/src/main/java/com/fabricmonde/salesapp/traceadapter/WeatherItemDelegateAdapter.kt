package com.fabricmonde.salesapp.traceadapter

import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.fabricmonde.salesapp.R
import com.fabricmonde.salesapp.tracemodel.Weather
import com.fabricmonde.salesapp.tracemodel.item_header_model
import com.fabricmonde.salesapp.tracemodel.productInfo
import kotlinx.android.synthetic.main.item_trace_weather.view.*
import pl.hypeapp.materialtimelineview.MaterialTimelineView
import java.util.ArrayList


class WeatherItemDelegateAdapter(activity: FragmentActivity?, productData: productInfo) : ViewTypeDelegateAdapter {

    var ctx: FragmentActivity? = activity
    var data: productInfo = productData


    override fun onCreateViewHolder(parent: ViewGroup): androidx.recyclerview.widget.RecyclerView.ViewHolder = WeatherItemViewHolder(parent)

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, item: ViewType) {
        holder as WeatherItemViewHolder
        holder.bind(item as Weather)
    }
    inner class WeatherItemViewHolder(parent: ViewGroup) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_trace_weather, parent, false)) {

        fun bind(item: Weather) = with(itemView) {
            // If is last item we need to change position type to last.
            if (item.isLastItem) {
                item_weather_timeline.position = MaterialTimelineView.POSITION_LAST
            }
            var image1 = arrayOf(R.drawable.pq,R.drawable.abc,R.drawable.abcd,R.drawable.abcde,R.drawable.xyz,R.drawable.ab,R.drawable.pqr,R.drawable.lmn,R.drawable.ab,R.drawable.abc)
            Log.i("POSITION", "")
            when (item.position) {
                0 -> {
                    var index = 0
                    var model = ArrayList<item_header_model>()
                    Log.i("HMM", data.getpSliverprepList().size.toString())
                    var tv1 = Array(data.getpSliverprepList().size) { "" }
                    var tv2 = Array(data.getpSliverprepList().size) { "" }
                    var tv3 = Array(data.getpSliverprepList().size) { "" }
                    for (i in data.getpSliverprepList()) {
                        tv1[index] = i.getgCompanyname()
                        tv2[index] = i.getgState()
                        tv3[index] = data.getpSliverCertification()
                        index += 1
                    }

                    for (i in tv1.indices) {
                        val ab = item_header_model(image1[i], tv1[i], tv2[i], tv3[i])
                        model.add(ab)
                    }
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rc4.layoutManager = layoutManager
                    rc4.itemAnimator = DefaultItemAnimator()
                    var adapter = item_header_adapter(context, model, ctx)
                    rc4.adapter = adapter

                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.sunny))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_weather_sunny))
                }
                1 -> {
                    var index = 0
                    var model = ArrayList<item_header_model>()
                    var tv1 = Array(data.getpSpinningList().size) { "" }
                    var tv2 = Array(data.getpSpinningList().size) { "" }
                    var tv3 = Array(data.getpSpinningList().size) { "" }
                    for (i in data.getpSpinningList()) {
                        tv1[index] = i.getgCompanyname()
                        tv2[index] = i.getgState()
                        tv3[index] = data.getpSpinningCertification()
                        index += 1
                    }
                    for (i in tv1.indices) {
                        val ab = item_header_model(image1[i], tv1[i], tv2[i], tv3[i])
                        model.add(ab)
                    }
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rc4.layoutManager = layoutManager
                    rc4.itemAnimator = DefaultItemAnimator()
                    var adapter = item_header_adapter(context, model, ctx)
                    rc4.adapter = adapter

                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.cloudy))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_cloud))

                }
                2 -> {
                    var index = 0
                    var model = ArrayList<item_header_model>()
                    var tv1 = Array(data.getpWeavingList().size) { "" }
                    var tv2 = Array(data.getpWeavingList().size) { "" }
                    var tv3 = Array(data.getpWeavingList().size) { "" }
                    for (i in data.getpWeavingList()) {
                        tv1[index] = i.getgCompanyname()
                        tv2[index] = i.getgState()
                        tv3[index] = data.getpWeavingCertification()
                        index += 1
                    }
                    for (i in tv1.indices) {
                        val ab = item_header_model(image1[i], tv1[i], tv2[i], tv3[i])
                        model.add(ab)
                    }
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rc4.layoutManager = layoutManager
                    rc4.itemAnimator = DefaultItemAnimator()
                    var adapter = item_header_adapter(context, model, ctx)
                    rc4.adapter = adapter

                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.rain))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_rain))

                }
                3 -> {
                    var index = 0
                    var model = ArrayList<item_header_model>()
                    var tv1 = Array(data.getpWashingList().size) { "" }
                    var tv2 = Array(data.getpWashingList().size) { "" }
                    var tv3 = Array(data.getpWashingList().size) { "" }
                    for (i in data.getpWashingList()) {
                        tv1[index] = i.getgCompanyname()
                        tv2[index] = i.getgState()
                        tv3[index] = data.getpWashingCertification()
                        index += 1
                    }
                    for (i in tv1.indices) {
                        val ab = item_header_model(image1[i], tv1[i], tv2[i], tv3[i])
                        model.add(ab)
                    }
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rc4.layoutManager = layoutManager
                    rc4.itemAnimator = DefaultItemAnimator()
                    var adapter = item_header_adapter(context, model, ctx)
                    rc4.adapter = adapter

                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.clear))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_clear))

                }
                4 -> {
                    var index = 0
                    var model = ArrayList<item_header_model>()
                    var tv1 = Array(data.getpSliverprepList().size) { "" }
                    var tv2 = Array(data.getpSliverprepList().size) { "" }
                    var tv3 = Array(data.getpSliverprepList().size) { "" }
                    for (i in data.getpSliverprepList()) {
                        tv1[index] = i.getgCompanyname()
                        tv2[index] = i.getgState()
                        tv3[index] = data.getpSliverCertification()
                        index += 1
                    }
                    for (i in tv1.indices) {
                        val ab = item_header_model(image1[i], tv1[i], tv2[i], tv3[i])
                        model.add(ab)
                    }
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rc4.layoutManager = layoutManager
                    rc4.itemAnimator = DefaultItemAnimator()
                    var adapter = item_header_adapter(context, model, ctx)
                    rc4.adapter = adapter

                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.clear))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_windy))
                }
                5 -> {
                    var index = 0
                    var model = ArrayList<item_header_model>()
                    var tv1 = Array(data.getpBleachingList().size) { "" }
                    var tv2 = Array(data.getpBleachingList().size) { "" }
                    var tv3 = Array(data.getpBleachingList().size) { "" }
                    for (i in data.getpBleachingList()) {
                        tv1[index] = i.getgCompanyname()
                        tv2[index] = i.getgState()
                        tv3[index] = data.getpBleachingCertification()
                        index += 1
                    }
                    for (i in tv1.indices) {
                        val ab = item_header_model(image1[i], tv1[i], tv2[i], tv3[i])
                        model.add(ab)
                    }
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rc4.layoutManager = layoutManager
                    rc4.itemAnimator = DefaultItemAnimator()
                    var adapter = item_header_adapter(context, model, ctx)
                    rc4.adapter = adapter

                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.sunny))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_weather_sunny))
                }
                6 -> {
                    var index = 0
                    var model = ArrayList<item_header_model>()
                    var tv1 = Array(data.getpInspectionList().size) { "" }
                    var tv2 = Array(data.getpInspectionList().size) { "" }
                    var tv3 = Array(data.getpInspectionList().size) { "" }
                    for (i in data.getpInspectionList()) {
                        tv1[index] = i.getgCompanyname()
                        tv2[index] = i.getgState()
                        tv3[index] = data.getpInspectionCertification()
                        index += 1
                    }
                    for (i in tv1.indices) {
                        val ab = item_header_model(image1[i], tv1[i], tv2[i], tv3[i])
                        model.add(ab)
                    }
                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    rc4.layoutManager = layoutManager
                    rc4.itemAnimator = DefaultItemAnimator()
                    var adapter = item_header_adapter(context, model, ctx)
                    rc4.adapter = adapter

                    item_weather_timeline.setBackgroundColor(ContextCompat.getColor(context, R.color.cloudy))
                    weather_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_cloud))
                }
            }
            /*recyclerview use*/
//            date.text = item.date
            weather_description.text = item.weatherDescription
            temperature_degree.text = "${item.temperature}\u00b0"
        }

    }




}
