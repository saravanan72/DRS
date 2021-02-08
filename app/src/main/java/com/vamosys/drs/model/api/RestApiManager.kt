package com.vamosys.drs.model.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestApiManager {
    var BASE_URL: String = "http://209.97.163.4:9910/v2/"

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