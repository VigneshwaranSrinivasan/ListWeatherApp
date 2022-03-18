package com.av.listweatherapp.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(detailsData:DetailsData)

    @Delete
    fun delete(detailsData : DetailsData)

    @Update
    fun update(detailsData:DetailsData)

    @Query("SELECT * FROM data_table ORDER BY id DESC")
    fun getAllData() : LiveData<List<DetailsData>>
}