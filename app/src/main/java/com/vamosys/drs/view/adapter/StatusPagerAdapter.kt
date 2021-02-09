package com.vamosys.drs.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.vamosys.drs.model.data.Data
import com.vamosys.drs.view.screen.fragment.MainFragment

class StatusPagerAdapter(fm: FragmentManager?, var data: Data) :
    FragmentStatePagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        return MainFragment.newInstance(position, data)
    }

    override fun getCount(): Int {
        return data.vehCountDetails?.size!!
    }
}