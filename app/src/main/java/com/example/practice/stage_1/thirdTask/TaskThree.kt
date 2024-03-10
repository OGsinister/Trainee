package com.example.practice.stage_1.thirdTask

fun removeElement(numbers: IntArray, number: Int): IntArray{
    return numbers
        .filter { it != number }
        .toIntArray()
}