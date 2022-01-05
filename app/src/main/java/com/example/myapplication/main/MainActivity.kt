package com.example.myapplication.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.data.InfoRepository
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View{
    private lateinit var mBinding : ActivityMainBinding

    private lateinit var presenter: MainPresenter
    private lateinit var repository: InfoRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        repository = InfoRepository(this)
        presenter = MainPresenter(this,repository)

        //처음 저장된 값이 있다면 불러온다
        presenter.initInfo()

        clickBtnListener()
    }

    override fun showInfo(info: String) {
        mBinding.text.text = info
    }
    fun clickBtnListener(){
        mBinding.btn.setOnClickListener {
            var info = mBinding.edittext.text.toString()
            presenter.setInfo(info)
            presenter.saveInfo(info)
        }
    }
}