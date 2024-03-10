package com.example.practice.stage_1.fourthTask

class MultiEven(private val list: List<Int>): List<Int> by list{
    fun multiIfEven(): List<Int> = list.map {
        if(it % 2  == 0){
            it * 2
        }else{
            it
        }
    }
}

fun List<Int>.multiIfEven(): List<Int> = map {
    if(it % 2 == 0){
        it * 2
    }else{
        it
    }
}