package com.av.listweatherapp.model

data class CurrentData(
    val dt: Double,
    val sunrise: Double,
    val sunset: Double,
    val temp: Double,
    val feels_like: Double,
    val pressure: Double,
    val humidity: Double,
    val dew_point: Double,
    val uvi: Int,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Double,
    val wind_deg: Double,
    val weather: List<WeatherSubData>
) {
}