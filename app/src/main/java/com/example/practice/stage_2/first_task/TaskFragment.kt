package com.example.practice.stage_2.first_task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.practice.R
import com.example.practice.databinding.FragmentTaskBinding
import com.example.practice.stage_2.second_task.Card

class TaskFragment : Fragment(R.layout.fragment_task) {
    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)

        val case1 = createFirstCard()
        val case2 = createSecondCard()

        _binding.apply {
            this?.userName?.text = case1.userName
            this?.cardText?.text = case1.description

            case1.image?.let { this?.optionalImage?.setImageResource(it) }
            case1.tags.forEach { text ->
                val textView = context?.let { context ->
                    createTextView(context, text)
                }
                _binding?.apply {
                    tagLayout.addView(textView)
                    flowContainer.addView(textView)
                }
            }
        }

        val view = binding.root
        return view
    }

    private fun createTextView(context: Context, text: String): TextView {
        val textView = TextView(context, null, 0, R.style.label)
        textView.id = View.generateViewId()
        textView.text = text
        textView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return textView
    }

    private fun createFirstCard(): Card {
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
    private fun createSecondCard(): Card{
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
}