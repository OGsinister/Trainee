package com.example.practice.thirdTask

fun removeElement(numbers: IntArray, number: Int): IntArray{
    return numbers
        .filter { it != number }
        .toIntArray()
}