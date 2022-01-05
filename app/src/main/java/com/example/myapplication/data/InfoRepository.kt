package com.example.myapplication.data

import android.content.Context
import com.example.myapplication.data.local.InfoLocalDataSource

class InfoRepository(context : Context) : InfoDataSource {
    private val infoLocalDataSource = InfoLocalDataSource(context)
    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) {
        infoLocalDataSource.getInfo(callback)
    }

    override fun saveInfo(info: String) {
        infoLocalDataSource.saveInfo(info)
    }
}