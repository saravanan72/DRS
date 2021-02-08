package com.vamosys.drs.controller

import com.vamosys.drs.model.DataAccessLayer
import com.vamosys.drs.view.callbacks.MainView

class MainController(private var model: DataAccessLayer) {
    private lateinit var mView: MainView

    fun bind(mainView: MainView){
        mView = mainView
    }

    fun onStatusRequestCall() {
        model.getStatusResponse(mView)
       // Log.i("RestAPI Controller", "onStatusRequestCall: "+model.getStatusResponse())
        //mView.setStatusResponse(model.getStatusResponse()!!)
    }
}