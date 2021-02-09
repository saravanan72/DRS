package com.vamosys.drs.view.screen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.gson.Gson
import com.vamosys.drs.R
import com.vamosys.drs.controller.ControllerModule
import com.vamosys.drs.controller.MainController
import com.vamosys.drs.model.data.DrsResponse
import com.vamosys.drs.view.adapter.StatusPagerAdapter
import com.vamosys.drs.view.callbacks.MainView
import com.vamosys.drs.view.util.Constants
import com.vamosys.drs.view.util.InternetCheck
import com.vamosys.drs.view.util.Progress
import com.vamosys.drs.view.util.SnackAlert

class MainActivity : AppCompatActivity(), MainView {

    private var controller:MainController? = null
    private var viewPager: ViewPager? = null
    private var tabLayout: TabLayout? = null
    private lateinit var noInterNetLayout: RelativeLayout
    private lateinit var contentLayout: ConstraintLayout
    private lateinit var progress: Progress

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller = ControllerModule(Constants.orgId).maincontroller()
        controller?.bind(this)

        noInterNetLayout = findViewById(R.id.no_internet_connection_layout)
        contentLayout = findViewById(R.id.main_content_layout)
        progress = Progress(this)

        if(progress!=null)
            progress.showProgressDialog()
        getApiCall()

        viewPager = findViewById(R.id.frameLayout)
        tabLayout = findViewById(R.id.tabs)

        findViewById<Button>(R.id.no_internet_btn_main).setOnClickListener(View.OnClickListener {

            if(progress!=null)
                progress.showProgressDialog()
            getApiCall()
        })
    }

    private fun getApiCall() {
        if (InternetCheck.isNetworkAvailable(this)){
            controller?.onStatusRequestCall()
            noInterNetLayout.visibility = ViewPager.GONE
            contentLayout.visibility = ViewPager.VISIBLE
        }else{
            val msg: String = ""+getString(R.string.no_internet_connection_lay_first_txt)+"\n"+getString(R.string.no_internet_connection_lay_second_txt)
            Snackbar.make(contentLayout, msg, Snackbar.LENGTH_SHORT).show()
            noInterNetLayout.visibility = ViewPager.VISIBLE
            contentLayout.visibility = ViewPager.GONE

            if(progress!=null)
                progress.cancelProgressDialog()

        }
    }

    override fun setStatusResponse(drsResponse: DrsResponse) {
        Log.i("RestAPI View", "getResponseData: "+Gson().toJson(drsResponse))
        val statusAdapter = drsResponse.data?.let {
            StatusPagerAdapter(supportFragmentManager,
                it
            )
        }
        drsResponse.data?.vehCountDetails?.forEach {
            tabLayout?.newTab()?.setText(it?.type + "(" + it?.count + ")")?.let { it1 ->
                tabLayout?.addTab(
                    it1
                )
            }
        }
        viewPager?.adapter = statusAdapter;
        viewPager?.offscreenPageLimit = 1
        viewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        TabLayout.TabLayoutOnPageChangeListener(tabLayout)
        if (tabLayout?.tabCount == 2)
            tabLayout?.tabMode = TabLayout.MODE_FIXED
        else
            tabLayout?.tabMode = TabLayout.MODE_SCROLLABLE

        tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager?.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        if(progress!=null)
            progress.cancelProgressDialog()
    }

    override fun setResponseError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}