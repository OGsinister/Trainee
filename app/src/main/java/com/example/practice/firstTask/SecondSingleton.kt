package com.example.practice.firstTask

import android.util.Log

class SecondSingleton private constructor(){
    private val userName: String = "Semyon"

    companion object{
        private var instance: SecondSingleton? = null

        fun getInstance(): SecondSingleton{
            if(instance == null){
                instance = SecondSingleton()
            }
            return instance!!
        }
    }

    fun printName(): String{
        Log.d("Username", userName)
        return userName
    }
}