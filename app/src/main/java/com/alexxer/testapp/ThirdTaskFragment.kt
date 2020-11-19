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
import com.alexxer.testapp.generating.PalindromeNumberGenerator
import com.alexxer.testapp.generating.SquareOddNumberGenerator
import com.alexxer.testapp.utils.Utils


class ThirdTaskFragment : Fragment() {
    private val adapter: NumberAdapter = NumberAdapter()

    private val numberGenerator: NumberGenerator = PalindromeNumberGenerator()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_third_task, container, false)
        val rv = root.findViewById<RecyclerView>(R.id.rv_3)
        val et = root.findViewById<EditText>(R.id.et_3)
        val button = root.findViewById<Button>(R.id.button_3)

        button.setOnClickListener {
            if (et.text.toString().isNotEmpty()) {
                val n = et.text.toString().toInt()
                val generateNumbers = numberGenerator.generateNumbers(n)
                adapter.setNumbers(generateNumbers)
                Utils.hideKeyboard(requireActivity())
            }
        }
        rv.adapter = adapter

        return root
    }
}