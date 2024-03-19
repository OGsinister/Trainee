package com.example.practice.stage_3.second_task

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.practice.R
import com.example.practice.stage_2.second_task.Card

abstract class BaseFragment(fragmentId: Int) : Fragment(fragmentId) {
    protected fun createFirstCard(): Card {
        return Card(
            userName = getString(R.string.UserName1),
            image = null,
            description = getString(R.string.HelloAdeleSong),
            sign = getString(R.string.sign1),
            tags = listOf(
                getString(R.string.tag1),
                getString(R.string.tag2),
                getString(R.string.tag3),
                getString(R.string.tag4),
                getString(R.string.tag5),
                getString(R.string.tag6),
                getString(R.string.tag7)
            )
        )
    }
    protected fun createSecondCard(): Card {
        return Card(
            userName = getString(R.string.UserName2),
            image = R.drawable.card_image,
            description = getString(R.string.desc2),
            sign = getString(R.string.sign2),
            tags = listOf(
                getString(R.string.tag2_1),
                getString(R.string.tag2_2),
                getString(R.string.tag2_3),
                getString(R.string.tag2_4),
                getString(R.string.tag2_5)
            )
        )
    }
    protected fun createTextView(context: Context, text: String): TextView {
        val textView = TextView(context, null, 0, R.style.label)
        textView.id = View.generateViewId()
        textView.text = text
        textView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return textView
    }
}
