package com.example.myapplication.main

import android.util.Log
import com.example.myapplication.data.InfoDataSource
import com.example.myapplication.data.InfoRepository

class MainPresenter(
    val view : MainContract.View,
    val repository : InfoRepository
) : MainContract.Presenter{
    override fun initInfo() {
        repository.getInfo(object: InfoDataSource.LoadInfoCallback{
            override fun onInfoLoaded(info: String) {
                Log.d("TAG", "onInfoLoaded: called")
                view.showInfo(info)
            }
            override fun onDataIsNull() {
                Log.d("TAG", "onDataIsNull: called ")
            }

        })
    }
    override fun setInfo(info: String) {
        view.showInfo(info)
    }

    override fun saveInfo(info: String) {
        repository.saveInfo(info)
    }
}