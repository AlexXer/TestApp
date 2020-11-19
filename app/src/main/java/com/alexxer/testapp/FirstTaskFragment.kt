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
import com.alexxer.testapp.generating.SquareFibonacciNumberGenerator
import com.alexxer.testapp.utils.Utils


class FirstTaskFragment : Fragment() {
    private val adapter: NumberAdapter = NumberAdapter()

    private val numberGenerator: NumberGenerator = SquareFibonacciNumberGenerator()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_first_task, container, false)
        val rv = root.findViewById<RecyclerView>(R.id.rv_1)
        val et = root.findViewById<EditText>(R.id.et_1)
        val button = root.findViewById<Button>(R.id.button_1)

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