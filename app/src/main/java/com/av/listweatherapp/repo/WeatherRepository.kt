package com.av.listweatherapp.repo

import com.av.listweatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTimeWeather() = apiService.getTimeWeather()
}