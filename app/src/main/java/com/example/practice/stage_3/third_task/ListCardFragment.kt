package com.example.practice.stage_3.third_task

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.practice.R
import com.example.practice.databinding.FragmentListCardBinding
import com.example.practice.stage_3.second_task.BaseFragment

class ListCardFragment : BaseFragment(R.layout.fragment_list_card) {
    private val binding by viewBinding(FragmentListCardBinding::bind)

    private lateinit var adapter: CardAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val case1 = createFirstCard()
        val case2 = createSecondCard()
        adapter = CardAdapter(listOf(case1,case2,case2,case1,case1,case2))

        with(binding){
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context)

            adapter.onCardClick = {
                findNavController().navigate(R.id.action_listCardFragment_to_taskFragment)
            }
        }
    }
}