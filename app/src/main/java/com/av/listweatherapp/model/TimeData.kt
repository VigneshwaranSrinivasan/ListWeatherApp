package com.av.listweatherapp.model

data class TimeData(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val current: List<CurrentData>,
    val minutly: List<MinutelyData>,
    val hourly: List<HourlyData>,
    val daily: List<DailyData>
)