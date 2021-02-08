package com.vamosys.drs.model.api

import com.vamosys.drs.model.data.DrsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RestApiService {

    @FormUrlEncoded
    @POST("basedrs/getVehicleLiveStatusBasedOrg?")
    fun getVehicleStatus(@Field("orgId") orgId: String): Call<DrsResponse>
}