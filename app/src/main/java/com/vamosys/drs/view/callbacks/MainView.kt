package com.vamosys.drs.view.callbacks

import com.vamosys.drs.model.data.DrsResponse

interface MainView {

    fun setStatusResponse(drsResponse: DrsResponse)
    fun setResponseError(error: String)
}