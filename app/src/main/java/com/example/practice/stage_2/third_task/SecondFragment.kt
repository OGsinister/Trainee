package com.example.practice.stage_2.third_task

import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.practice.R
import com.example.practice.databinding.FragmentSecondBinding
import com.example.practice.stage_3.fourth_task.FileAdapter
import com.example.practice.stage_3.second_task.BaseFragment


class SecondFragment : BaseFragment(R.layout.fragment_second) {
    private val binding by viewBinding(FragmentSecondBinding::bind)
    private var adapter: FileAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val downloadedFileNames = getFilesFromDownloads()
        adapter = FileAdapter(downloadedFileNames)

        with(binding){
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(context)

            btnNav.setOnClickListener{
                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }
        }
    }
}

private fun getFilesFromDownloads(): List<String> {
    val downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val fileList = mutableListOf<String>()

    downloadDirectory.walkTopDown().forEach {
        fileList.add("${it.path}: ${it.name}")
    }
    downloadDirectory.walkBottomUp().forEach {
        fileList.add("${it.path}: ${it.name}")
    }

    return fileList
}
