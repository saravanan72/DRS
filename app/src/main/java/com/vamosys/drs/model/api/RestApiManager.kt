package com.vamosys.drs.model.api

import com.vamosys.drs.view.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApiManager {
    var BASE_URL: String = Constants.Base_Url

    fun getRestApi(): Retrofit? {
        var retrofit: Retrofit? = null
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    public val apiService: RestApiService? = getRestApi()?.create(RestApiService::class.java)
}