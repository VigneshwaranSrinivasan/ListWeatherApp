package com.av.listweatherapp.api

import com.av.listweatherapp.model.TimeData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("data/2.5")
    suspend fun getTimeWeather(): Response<TimeData>
}