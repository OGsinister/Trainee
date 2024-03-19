package com.example.practice.stage_2.third_task

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.practice.R
import com.example.practice.databinding.FragmentSecondBinding
import com.example.practice.stage_3.second_task.BaseFragment

class SecondFragment : BaseFragment(R.layout.fragment_second) {
    private val binding by viewBinding(FragmentSecondBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            btnNav.setOnClickListener{
                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }
        }
    }
}