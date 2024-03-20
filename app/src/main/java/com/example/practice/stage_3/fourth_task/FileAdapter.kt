package com.example.practice.stage_3.fourth_task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.FileItemBinding

class FileAdapter(private val items: List<String>): RecyclerView.Adapter<FileAdapter.FileViewHolder>() {
    private var _binding: FileItemBinding? = null
    private val binding get() = _binding!!

    class FileViewHolder(val binding: FileItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        _binding = FileItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        holder.binding.fileName.text = items[position]
    }

    override fun getItemCount() = items.size
}