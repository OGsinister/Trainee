package com.example.practice.stage_1.firstTask

import android.util.Log

object FirstSingleton {
    private var name = "Semyon"
    fun printName(): String = name.also { Log.d("UserName", name) }
}