package com.av.listweatherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.av.listweatherapp.repo.Repository
import com.av.listweatherapp.room.DetailsData
import com.av.listweatherapp.room.DetailsDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(app : Application) : AndroidViewModel(app) {

    private val readAllData1: LiveData<List<DetailsData>>
    private val repository : Repository

    init {
        val datadao = DetailsDataBase.getDatabase(app).dataDao()
        repository = Repository(datadao)
        readAllData1 = repository.readAllDetailsData
    }

    fun insertData(data : DetailsData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(data)
        }
    }

}