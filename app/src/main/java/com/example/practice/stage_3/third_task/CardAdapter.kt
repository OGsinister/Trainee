package com.example.practice.stage_3.third_task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.CardItemBinding
import com.example.practice.stage_2.second_task.Card

class CardAdapter(private val items: List<Card>): RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    private var _binding: CardItemBinding? = null
    private val binding get() = _binding!!

    var onCardClick: (() -> Unit)? = null

    class CardViewHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        _binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        items[position].image?.let { holder.binding.optionalImage.setImageResource(it) }
        holder.binding.userName.text = items[position].userName
        holder.binding.sign.text = items[position].sign

        holder.itemView.setOnClickListener{
            onCardClick?.invoke()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}