package com.av.listweatherapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [DetailsData::class],version = 1)
abstract class DetailsDataBase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {
        private var INSTANCE: DetailsDataBase?=null

        fun getDatabase(context :Context):DetailsDataBase{
            val tempinstance = INSTANCE
            if(tempinstance!=null) {
                return  tempinstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,DetailsDataBase::class.java,"user_databas")
                    .build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}



