package com.example.practice.stage_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.R
import com.example.practice.stage_2.first_task.TaskFragment

class StageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stage)

        val fragment = TaskFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, fragment)
            .commit()
    }
}