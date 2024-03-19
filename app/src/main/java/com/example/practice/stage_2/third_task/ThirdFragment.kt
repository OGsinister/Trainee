package com.example.practice.stage_2.third_task

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.practice.R
import com.example.practice.databinding.FragmentThirdBinding
import com.example.practice.stage_3.second_task.BaseFragment

class ThirdFragment : BaseFragment(R.layout.fragment_third) {
    private val binding by viewBinding(FragmentThirdBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            BtnNav.setOnClickListener{
                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
            }
        }

        val backPressedCallback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
                }
            }

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, backPressedCallback)
    }
}