package com.vamosys.drs.model

import com.vamosys.drs.controller.MainController
import com.vamosys.drs.model.repository.VehicleStatusRepository

class DataAccessLayer(private val vehicleStatusRepository: VehicleStatusRepository) {

    fun getStatusResponse(mController: MainController) {
        vehicleStatusRepository.getStatusResponse(mController)
    }

}