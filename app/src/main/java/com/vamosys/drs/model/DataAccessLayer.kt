package com.vamosys.drs.model

import com.vamosys.drs.model.repository.VehicleStatusRepository
import com.vamosys.drs.view.callbacks.MainView

class DataAccessLayer(private val vehicleStatusRepository: VehicleStatusRepository) {

    fun getStatusResponse(mView: MainView) {
        vehicleStatusRepository.getStatusResponse(mView)
    }

}