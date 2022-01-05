package com.example.myapplication.data.local

import android.content.Context
import com.example.myapplication.data.InfoDataSource

class InfoLocalDataSource(context : Context) : InfoDataSource {
    private val sharedPreferences = context.getSharedPreferences("info",Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()
    override fun getInfo(callback: InfoDataSource.LoadInfoCallback) {
        var info = sharedPreferences.getString("info",null)
        if(info!=null){
            callback.onInfoLoaded(info)
        }
        else{
            callback.onDataIsNull()
        }
    }
    override fun saveInfo(info: String) {
        editor.putString("info",info)
        editor.commit()
    }
}