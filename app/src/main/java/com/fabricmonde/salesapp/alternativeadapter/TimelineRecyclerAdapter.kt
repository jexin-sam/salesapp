package com.fabricmonde.salesapp.alternativeadapter


import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.fabricmonde.salesapp.alternativemodel.CityWeather
import com.fabricmonde.salesapp.alternativemodel.Timepoint
import com.fabricmonde.salesapp.alternativemodel.Weather

class TimelineRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>

    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        items = ArrayList()
        delegateAdapters.put(ViewType.HEADER, WeatherHeaderItemDelegateAdapter())
        delegateAdapters.put(ViewType.LINE, TimepointItemDelegateAdapter())
        delegateAdapters.put(ViewType.ITEM, WeatherItemDelegateAdapter())
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
