package com.av.listweatherapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "data_table")
data class DetailsData(val firstName:String,
                       val lastName:String,
                       val emailAddress:String,
                       /*val profilePicture:Int,*/
                       @PrimaryKey(autoGenerate = true) val id: Int=0 )
