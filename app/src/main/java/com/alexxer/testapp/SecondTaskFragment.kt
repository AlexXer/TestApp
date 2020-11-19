package com.alexxer.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.alexxer.testapp.generating.NumberGenerator

import com.alexxer.testapp.generating.SquareOddNumberGenerator
import com.alexxer.testapp.utils.Utils


class SecondTaskFragment : Fragment() {
    private val adapter: NumberAdapter = NumberAdapter()

    private val numberGenerator: NumberGenerator = SquareOddNumberGenerator()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_second_task, container, false)
        val rv = root.findViewById<RecyclerView>(R.id.rv_2)
        val et = root.findViewById<EditText>(R.id.et_2)
        val button = root.findViewById<Button>(R.id.button_2)

        button.setOnClickListener {
            if (et.text.toString().isNotEmpty()) {
                val n = et.text.toString().toInt()
                if (n in 0..65535) {
                    val generateNumbers = numberGenerator.generateNumbers(n)
                    adapter.setNumbers(generateNumbers)
                    Utils.hideKeyboard(requireActivity())
                }
            }
        }
        rv.adapter = adapter

        return root
    }
}