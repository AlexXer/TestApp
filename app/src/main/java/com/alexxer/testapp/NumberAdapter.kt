package com.alexxer.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter() : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {
    private var numbers: IntArray = IntArray(0)

    class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberTextView: TextView = itemView.findViewById(R.id.tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.numberTextView.text = numbers[position].toString()
    }

    override fun getItemCount(): Int = numbers.size

    fun setNumbers(numbers: IntArray) {
        this.numbers = numbers
        notifyDataSetChanged()
    }
}