package com.fabricmonde.salesapp.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.fabricmonde.salesapp.R
import com.fabricmonde.salesapp.interfaces.Interface
import com.fabricmonde.salesapp.traceadapter.TimelineRecyclerAdapter
import com.fabricmonde.salesapp.tracemodel.CityWeather
import com.fabricmonde.salesapp.tracemodel.Timepoint
import com.fabricmonde.salesapp.tracemodel.Weather
import kotlinx.android.synthetic.main.tracestorykit.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Storykit.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Storykit.newInstance] factory method to
 * create an instance of this fragment.
 *
 */

class TraceStorykit() : androidx.fragment.app.Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var listener: Interface

    private var root: View? = null
    lateinit var timelineRecyclerAdapter: TimelineRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       root = inflater.inflate(R.layout.tracestorykit, container, false)


        timelineRecyclerAdapter = TimelineRecyclerAdapter(activity,listener.productData)
        root!!.recycler_view.adapter = timelineRecyclerAdapter
        root!!.recycler_view.layoutManager = LinearLayoutManager(context)
        root!!.recycler_view.isNestedScrollingEnabled = false
        timelineRecyclerAdapter.addWeatherHeader(cityWeather)
        for (i in 0..5) {
            timelineRecyclerAdapter.addTimepoint(timepoints[i])
            timelineRecyclerAdapter.addWeather(weatherList[i])
        }




        return root
    }

    // TODO: Rename method, update argument and hook method into UI event
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Interface) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object FakeData {
        val cityWeather: CityWeather = CityWeather("JOURNEY OF THIS FABRIC",
                "Sunny", 21.5f, "5%", "56%", "25km/h")

        val timepoints: ArrayList<Timepoint> = arrayListOf(
                Timepoint("Next 6 hours", "Sunny"),
                Timepoint("Next 24 hours", "Clear sky"),
                Timepoint("Next day", "Cloudy"),
                Timepoint("Next 2 days from now", "Rainy"),
                Timepoint("Next 3 days from now", "Sunny"),
                Timepoint("Next week", "Clear sky"))




        val weatherList: ArrayList<Weather> = arrayListOf(
                Weather(0, "Sunny", 24f),
                Weather(1, "Clear sky", 22.2f),
                Weather(2, "Cloudy", 18.5f),
                Weather(3, "Rain fall", 18f),
                Weather(4, "Sunny", 21.5f),
                Weather(5, "Sunny", 21.5f),
                Weather(6, "Windy", 19.7f, isLastItem = true)
        )

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Storykit.
         */
    }


}
