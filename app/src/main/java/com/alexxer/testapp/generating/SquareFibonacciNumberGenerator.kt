package com.alexxer.testapp.generating

class SquareFibonacciNumberGenerator:NumberGenerator {
    override fun generateNumbers(n: Int): IntArray {
        var list = arrayListOf<Int>(0, 1)
        while (list[list.size - 2] + list[list.size - 1] < n) {
            list.add((list[list.size-1]+list[list.size-2]))
        }
        list = list.filter { it<n } as ArrayList<Int>
        return list.map { it*it }.toIntArray()
    }

}

