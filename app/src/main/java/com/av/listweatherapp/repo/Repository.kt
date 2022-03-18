package com.av.listweatherapp.repo

import android.content.Context
import android.telecom.Call
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LiveData
import androidx.room.Database
import com.av.listweatherapp.room.DataDao
import com.av.listweatherapp.room.DetailsData
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

class Repository(private val datadao :DataDao) {

    val readAllDetailsData : LiveData<List<DetailsData>> = datadao.getAllData()

    suspend fun insertData(data:DetailsData){
        datadao.insert(data)
    }

}