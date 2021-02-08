package com.vamosys.drs.model

import com.vamosys.drs.model.api.RestApiManager
import com.vamosys.drs.model.repository.VehicleStatusRepository

class ModelModule(private var orgId: String) {

    val dataAccessLayer: DataAccessLayer by lazy { dataAccessLayer() }

    private fun dataAccessLayer() =
        DataAccessLayer(VehicleStatusRepository(RestApiManager.apiService, orgId))

}