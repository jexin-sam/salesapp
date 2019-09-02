package com.fabricmonde.salesapp.fragments

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import com.fabricmonde.salesapp.Flag
import com.fabricmonde.salesapp.R
import com.fabricmonde.salesapp.alternativeadapter.TimelineRecyclerAdapter
import com.fabricmonde.salesapp.alternativemodel.CityWeather
import com.fabricmonde.salesapp.alternativemodel.Timepoint
import com.fabricmonde.salesapp.alternativemodel.Weather
import com.moos.library.HorizontalProgressView
import kotlinx.android.synthetic.main.alternativestorykit.view.*
import android.view.ViewTreeObserver
import com.fabricmonde.salesapp.customscrollview.ScrollViewWithListener


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

class AlternativeStorykit : androidx.fragment.app.Fragment() ,ScrollViewWithListener.ScrollViewListener {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    val scroller : ScrollViewWithListener? = null

    private var root: View? = null

    val flag = Flag()

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
        root = inflater.inflate(R.layout.alternativestorykit, container, false)


        timelineRecyclerAdapter = TimelineRecyclerAdapter()
        root!!.recycler_view.adapter = timelineRecyclerAdapter
        root!!.recycler_view.layoutManager = LinearLayoutManager(context)
        root!!.recycler_view.isNestedScrollingEnabled = false
        timelineRecyclerAdapter.addWeatherHeader(cityWeather0)
        for (i in 0..1) {
            timelineRecyclerAdapter.addTimepoint(timepoints[i])
            timelineRecyclerAdapter.addWeatherHeader(cityWeather1)
        }
        timelineRecyclerAdapter.addTimepoint(timepoints[2])
        timelineRecyclerAdapter.addWeatherHeader(cityWeather2)


        val progressbarwidth = root!!.findViewById<HorizontalProgressView>(R.id.progressbar_width)
        val progressbarcount = root!!.findViewById<HorizontalProgressView>(R.id.progressbar_count)
        val progressbarconstruction = root!!.findViewById<HorizontalProgressView>(R.id.progressbar_construction)
        val progressbargsm = root!!.findViewById<HorizontalProgressView>(R.id.progressbar_gsm)
        val progressbarcolor = root!!.findViewById<HorizontalProgressView>(R.id.progressbar_color)

        progressbarwidth.setProgressViewUpdateListener(object : HorizontalProgressView.HorizontalProgressUpdateListener {

            override fun onHorizontalProgressStart(view: View) {}
            override fun onHorizontalProgressUpdate(view: View, progress: Float) {
                /**
                 * you can detail with progressViews' animate event and customize their animate order
                 */
            }

            override fun onHorizontalProgressFinished(view: View) {

            }
        })




        flag.listener = Flag.ChangeListener {
            if (flag.boolean) {

                progressbarwidth.startProgressAnimation()
                progressbarcount.startProgressAnimation()
                progressbarconstruction.startProgressAnimation()
                progressbargsm.startProgressAnimation()
                progressbarcolor.startProgressAnimation()

            }
        }


        val scroll = root!!.findViewById<ScrollViewWithListener>(R.id.scroll)

        scroll.setScrollViewListener(object : ScrollViewWithListener.ScrollViewListener {
            override fun onScrollChanged(scrollView: ScrollViewWithListener, x: Int, y: Int, oldx: Int, oldy: Int) {

            }
            override fun onEndScroll() {
                flag.boolean=true

            }
        })


//        scroll.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
//            val scrollBounds = Rect()
//            v.getHitRect(scrollBounds)
//            if (!quality.getLocalVisibleRect(scrollBounds) || scrollBounds.height() < quality.height) {
//                // imageView is not within or only partially within the visible window
//                Log.i("SCROLLSTUFF", "PARTIAL  X: $scrollX Y: $scrollY")
//
//            } else {
//                // imageView is completely visible
//                Log.i("SCROLLSTUFF", "FULL  X: $scrollX Y: $scrollY")
//                flag.boolean = true
//
//            }
//        }

        return root
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
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

    override fun onEndScroll() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

//        Log.i("SCROLLSTUFF", "FULL  X:")
        flag.boolean = true


    }
    override fun onScrollChanged(scrollView: ScrollViewWithListener?, x: Int, y: Int, oldx: Int, oldy: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object FakeData {
        val cityWeather0: CityWeather = CityWeather("Sukhvinder Singh", "Cotton Farmer ", 21.5f, "Haryana, Punjab", "56%", "Certified By : GOTS", isFirstItem = true)
        val cityWeather1: CityWeather = CityWeather("Sukhvinder Singh", "Cotton Farmer ", 21.5f, "Haryana, Punjab", "56%", "Certified By : GOTS")
        val cityWeather2: CityWeather = CityWeather("Sukhvinder Singh", "Cotton Farmer ", 21.5f, "Haryana, Punjab", "56%", "Certified By : GOTS", isLastItem = true)


        val timepoints: ArrayList<Timepoint> = arrayListOf(
                Timepoint("Next 6 hours", "Sunny"),
                Timepoint("Next 24 hours", "Clear sky"),
                Timepoint("Next day", "Cloudy"),
                Timepoint("Next 2 days from now", "Rainy"),
                Timepoint("Next 3 days from now", "Sunny"),
                Timepoint("Next week", "Clear sky"))

    }
}
