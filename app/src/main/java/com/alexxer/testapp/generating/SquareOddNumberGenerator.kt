package com.alexxer.testapp.generating

class SquareOddNumberGenerator : NumberGenerator {
    override fun generateNumbers(n: Int): IntArray {
        val list = arrayListOf<Int>()
        for (j in 1..n step 2) {
            list.add(j * j)
        }
        return list.toIntArray()
    }
}