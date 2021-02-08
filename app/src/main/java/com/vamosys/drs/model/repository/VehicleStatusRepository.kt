package com.vamosys.drs.model.repository

import android.util.Log
import com.google.gson.Gson
import com.vamosys.drs.model.api.RestApiService
import com.vamosys.drs.model.data.DrsResponse
import com.vamosys.drs.view.callbacks.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class VehicleStatusRepository(private val apiHelper: RestApiService?, private var orgId: String) {

    fun getStatusResponse(mView: MainView): DrsResponse? {
        val apiService = apiHelper
        var drsResponse: DrsResponse? = null
        apiService?.getVehicleStatus(orgId)?.enqueue(object : Callback<DrsResponse> {
            override fun onResponse(
                call: Call<DrsResponse>,
                response: Response<DrsResponse>
            ) {
                val statusCode = response.code()
                Log.i("RestAPI Repo", "onResponse: "+ Gson().toJson(response.body()))
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    drsResponse = response.body()
                    drsResponse?.let { mView.setStatusResponse(it) }
                }else{
                    mView.setResponseError(response.message())
                }
            }

            override fun onFailure(call: Call<DrsResponse>, t: Throwable) {
                // Log error here since request failed
                Log.e("RestAPI Error", t.toString())
                mView.setResponseError(t.localizedMessage)
            }
        })
        return drsResponse
    }
}