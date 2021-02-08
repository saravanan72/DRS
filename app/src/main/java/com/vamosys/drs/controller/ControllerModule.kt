package com.vamosys.drs.controller

import com.vamosys.drs.model.ModelModule

class ControllerModule(private val orgId: String) {
    fun maincontroller() = MainController(ModelModule(orgId).dataAccessLayer)
}