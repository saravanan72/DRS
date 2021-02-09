package com.vamosys.drs.view.screen.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.vamosys.drs.R
import com.vamosys.drs.model.data.Data
import com.vamosys.drs.model.data.DataStatusItem
import com.vamosys.drs.view.adapter.StatusRecyclerAdapter

class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: Data? = null
    private var list = mutableListOf<DataStatusItem>()
    private var recyclerView: RecyclerView? = null
    private var noItemLayout: RelativeLayout? = null
    private lateinit var adapter: StatusRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt("ARG_PARAM1")
            param2 = it.getParcelable("ARG_PARAM2")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("MainFragment", "onCreateView: "+Gson().toJson(param2))
        param2?.dataStatus?.forEach {
            if (param1 == 0)
                list.add(it!!)
            else {
                var item1 = param1?.let { it1 -> param2?.vehCountDetails?.get(it1)?.type }
                var item2 = it?.currentVehicleStatusType
                if (item1 == item2) {
                    list.add(it!!)
                }
            }
        }
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.statusRecyclerview)
        noItemLayout = view.findViewById(R.id.no_item_layout)
        if (list.size>0) {
            adapter = activity?.let { StatusRecyclerAdapter(it, list) }!!
            recyclerView?.adapter = adapter
            recyclerView?.visibility = View.VISIBLE
            noItemLayout?.visibility = View.GONE
        }else{
            recyclerView?.visibility = View.GONE
            noItemLayout?.visibility = View.VISIBLE
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Int, data: Data) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putInt("ARG_PARAM1", param1)
                    putParcelable("ARG_PARAM2", data)
                }
            }
    }
}