package com.example.myapplication.main

interface MainContract {
    interface View{
        //텍스트뷰에 데이터를 보여준다
        fun showInfo(info : String)
    }
    interface Presenter {
        //onCreate시 SharedPreference를 확인하여
        //저장된 데이터가 있는지 Model에서 확인하고
        //결과에 따라 저장된 데이터가 존재하면 View에 어떤 내용을 보여줄지 지시함
        fun initInfo()

        //TextView에 info 데이터를 보여주라고 View에게 지시한다
        fun setInfo(info : String)

        //EditText에 입력된 데이터를 저장하라고 Model에게 지시한다.
        fun saveInfo(info : String)
    }
}