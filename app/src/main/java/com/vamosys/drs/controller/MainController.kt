package com.vamosys.drs.controller

import com.vamosys.drs.model.DataAccessLayer
import com.vamosys.drs.model.data.DrsResponse
import com.vamosys.drs.view.callbacks.MainView

class MainController(private var model: DataAccessLayer) {
    private lateinit var mView: MainView

    fun bind(mainView: MainView){
        mView = mainView
    }

    fun onStatusRequestCall() {
        model.getStatusResponse(this)
    }

    fun setApiResponse(response: DrsResponse) {
        mView.setStatusResponse(response)
    }

    fun setResponseError(message: String) {
        mView.setResponseError(message)
    }
}