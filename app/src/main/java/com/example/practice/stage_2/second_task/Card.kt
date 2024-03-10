package com.example.practice.stage_2.second_task

data class Card(
    val userName: String,
    val image: Int? = null,
    val description: String,
    val sign: String,
    val tags: List<String>
)
