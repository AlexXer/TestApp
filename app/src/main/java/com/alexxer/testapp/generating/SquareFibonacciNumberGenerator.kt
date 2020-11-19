package com.alexxer.testapp.generating

class SquareFibonacciNumberGenerator:NumberGenerator {
    override fun generateNumbers(n: Int): IntArray {
        val list = arrayListOf<Int>(0, 1)
        while (list[list.size - 2] + list[list.size - 1] < n) {
            list.add((list[list.size-1]+list[list.size-2]))
        }
        return list.map { it*it }.toIntArray()
    }

}

