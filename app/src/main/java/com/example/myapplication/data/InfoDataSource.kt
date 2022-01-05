package com.example.myapplication.data

interface InfoDataSource {
    interface LoadInfoCallback{
        fun onInfoLoaded(info : String)
        fun onDataIsNull()
    }
    fun getInfo(callback : LoadInfoCallback)
    fun saveInfo(info : String)
}