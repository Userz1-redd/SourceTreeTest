package com.example.myapplication

import android.app.Application

class App : Application(){
    var instance : App? = null
    override fun onCreate(){
        super.onCreate()
        instance = App()
    }
}