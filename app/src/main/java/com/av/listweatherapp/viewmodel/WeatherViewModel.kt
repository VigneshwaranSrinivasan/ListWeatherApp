package com.av.listweatherapp.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.av.listweatherapp.model.TimeData
import com.av.listweatherapp.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository) : ViewModel() {

    private val _response = MutableLiveData<TimeData>()
    val weatherResponse: LiveData<TimeData>
        get() = _response


    init {
        getTimeWeather()
    }

    private fun getTimeWeather() = viewModelScope.launch {
        repository.getTimeWeather().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }


}













