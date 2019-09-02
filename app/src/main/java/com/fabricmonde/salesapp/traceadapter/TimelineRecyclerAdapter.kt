package com.fabricmonde.salesapp.traceadapter

import android.util.Log
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.fabricmonde.salesapp.tracemodel.CityWeather
import com.fabricmonde.salesapp.tracemodel.Timepoint
import com.fabricmonde.salesapp.tracemodel.Weather
import com.fabricmonde.salesapp.tracemodel.productInfo


class TimelineRecyclerAdapter(activity: FragmentActivity?, productData: productInfo) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType> = ArrayList()

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        delegateAdapters.put(ViewType.HEADER, WeatherHeaderItemDelegateAdapter())
        //delegateAdapters.put(ViewType.LINE, TimepointItemDelegateAdapter())
        delegateAdapters.put(ViewType.ITEM, WeatherItemDelegateAdapter(activity,productData))

    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun addWeatherHeader(item: CityWeather) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    fun addWeather(item: Weather) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    fun addTimepoint(item: Timepoint) {
        this.items.add(item)
        notifyDataSetChanged()
    }

}
