package com.example.practice.stage_2.first_task

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.practice.R
import com.example.practice.databinding.FragmentTaskBinding
import com.example.practice.stage_3.second_task.BaseFragment

class TaskFragment : BaseFragment(R.layout.fragment_task) {
    private val binding by viewBinding(FragmentTaskBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val case1 = createFirstCard()
        val case2 = createSecondCard()

        with(binding){
            userName.text = case1.userName
            cardText.text = case1.description

            case1.image?.let { optionalImage.setImageResource(it) }
            case1.tags.forEach { text ->
                val textView = context?.let { context ->
                    createTextView(context, text)
                }
                tagLayout.addView(textView)
                flowContainer.addView(textView)
            }

            button.setOnClickListener {
                view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }

            exitButton.setOnClickListener {
                Toast.makeText(context, getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
            }
        }
    }
}