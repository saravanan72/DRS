package com.vamosys.drs.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vamosys.drs.R
import com.vamosys.drs.model.data.DataStatusItem
import com.vamosys.drs.model.data.LoadingLocationListItem
import com.vamosys.drs.view.util.Utils

class StatusRecyclerAdapter(private val context: Context, private var list: MutableList<DataStatusItem>): RecyclerView.Adapter<StatusRecyclerAdapter.StatusViewHolder>() {

    class StatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val status = itemView.findViewById<TextView>(R.id.status_item_status_txtvw)
        val vehicleStartTime = itemView.findViewById<TextView>(R.id.status_item_type_txtvw)
        val vehicleNumber = itemView.findViewById<TextView>(R.id.status_item_vehicle_number_txtvw)
        val vehicleStartLoc = itemView.findViewById<TextView>(R.id.status_item_vehicle_location_txtvw)
        val vehicleStartSince = itemView.findViewById<TextView>(R.id.status_item_vehicle_start_since_txtvw)
        val vehicleDriverName = itemView.findViewById<TextView>(R.id.status_item_vehicle_driver_name_txtvw)
        val vehicleLoadLoc = itemView.findViewById<TextView>(R.id.status_item_vehicle_loaded_loc_txtvw)
        val vehicleUnlLoadLoc = itemView.findViewById<TextView>(R.id.status_item_vehicle_unload_loc_txtvw)
        val vehicleLoadCmpltTime = itemView.findViewById<TextView>(R.id.status_item_vehicle_load_complt_time_txtvw)
        val vehicleEatDest = itemView.findViewById<TextView>(R.id.status_item_vehicle_eat_dest_txtvw)
        val vehicleFeulLevel = itemView.findViewById<TextView>(R.id.status_item_feul_level_txtvw)
        val vehicleFeulUpdateLoc = itemView.findViewById<TextView>(R.id.status_item_feul_update_loc_txtvw)
        val vehicleDistancecmpltd = itemView.findViewById<TextView>(R.id.status_item_truck_distance_completed_txtvw)
        val vehicleFeulFile = itemView.findViewById<TextView>(R.id.status_item_truck_feul_filled_txtvw)
        val vehicleFeulStateCheckList = itemView.findViewById<TextView>(R.id.status_item_truck_feul_checklist_txtvw)
        val vehicleDriverContact = itemView.findViewById<TextView>(R.id.status_item_truck_driver_contact_txtvw)
        val vehicleAlertInfo = itemView.findViewById<TextView>(R.id.status_item_truck_info_alert_txtvw)
        val vehicleFullHistory = itemView.findViewById<TextView>(R.id.status_item_truck_history_txtvw)
        val truckImageview = itemView.findViewById<ImageView>(R.id.status_item_truck_imgvw)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        return StatusViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_status_item, parent, false))
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {

        val statusItem: DataStatusItem = getItem(position)
        holder.status.text = "Status: "+ if (statusItem.vehicleStatus != null ) statusItem.vehicleStatus else "-"
        holder.vehicleStartTime.text = statusItem.tripStartedTime?.let {
            Utils.epochToDateTime(
                it
            )
        }

        holder.vehicleNumber.text = if (statusItem.vehicleName != null ) statusItem.vehicleName else "-"
        holder.vehicleStartLoc.text = if(statusItem.startLocation!=null) statusItem.startLocation else "-"
        var timDiff = Utils.getHoursDiff(statusItem.tripStartedTime)
        holder.vehicleStartSince.text = "Moving Since $timDiff"
        holder.vehicleDriverName.text = if(statusItem.driverName!=null) statusItem.driverName else "-"
        if (statusItem.loadingLocationList != null){
            val loadingList:List<LoadingLocationListItem> = statusItem.loadingLocationList as List<LoadingLocationListItem>
            holder.vehicleLoadLoc.text = loadingList[0].location
            holder.vehicleLoadCmpltTime.text = loadingList[0].time?.let {
                Utils.epochToDateTime(
                    it
                )
            }
        }else{
            holder.vehicleLoadLoc.text = "-"
            holder.vehicleLoadCmpltTime.text = "-"
        }
        if (statusItem.unLoadingLocationList != null){
            val unLoadingList:List<LoadingLocationListItem> = statusItem.unLoadingLocationList as List<LoadingLocationListItem>
            holder.vehicleUnlLoadLoc.text = unLoadingList[0].location
            holder.vehicleEatDest.text = unLoadingList[0].time?.let {
                Utils.epochToDateTime(
                    it
                )
            }
        }else{
            holder.vehicleUnlLoadLoc.text = "-"
            holder.vehicleEatDest.text = "-"
        }
        var fuelLevel = statusItem.startFuelLevel
        var installStatus = statusItem.installStatus
        var count = statusItem.count
        holder.vehicleFeulLevel.text = if(statusItem.startFuelLevel!=null) "$fuelLevel L" else "0L"
        holder.vehicleFeulUpdateLoc.text = if(statusItem.startLocation!=null) statusItem.startLocation else "-"
        holder.vehicleDistancecmpltd.text = if(statusItem.installStatus!=null) "$installStatus" else "0"
        holder.vehicleFeulFile.text = if(statusItem.count!=null) "$count" else "0"
        holder.truckImageview.setImageResource(
            if ((position%3) ==0)
                R.drawable.ic_big_truck
            else if ((position%3) ==1)
                R.drawable.ic_midsize_truck
            else
                R.drawable.ic_small_size_truck
        )
        if ((position%3) ==0)
            holder.truckImageview.setImageResource(R.drawable.ic_big_truck)
        else if ((position%3) ==1)
            holder.truckImageview.setImageResource(R.drawable.ic_midsize_truck)
        else
            holder.truckImageview.setImageResource(R.drawable.ic_small_size_truck)


    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun getItem(position: Int): DataStatusItem {
        return list[position]
    }
}