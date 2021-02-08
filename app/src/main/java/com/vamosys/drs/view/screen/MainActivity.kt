package com.vamosys.drs.view.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.vamosys.drs.R
import com.vamosys.drs.controller.ControllerModule
import com.vamosys.drs.controller.MainController
import com.vamosys.drs.model.data.DrsResponse
import com.vamosys.drs.view.callbacks.MainView
import com.vamosys.drs.view.util.Constants

class MainActivity : AppCompatActivity(), MainView {

    private var controller:MainController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller = ControllerModule(Constants.orgId).maincontroller()
        controller?.bind(this)
        controller?.onStatusRequestCall()
    }
    override fun setStatusResponse(drsResponse: DrsResponse) {
        Log.i("RestAPI View", "getResponseData: "+Gson().toJson(drsResponse))
    }

    override fun setResponseError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}