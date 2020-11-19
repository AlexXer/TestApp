package com.alexxer.testapp.generating

class PalindromeNumberGenerator : NumberGenerator {
    override fun generateNumbers(n: Int): IntArray {
        val list = arrayListOf<Int>()
        var palindrome:Int
        for (j in 0..1) {

            var i = 1
            palindrome = createPalindrome(i, 10, j % 2)
            while (palindrome < n) {
                list.add(palindrome)
                i++
                palindrome = createPalindrome(i, 10, j % 2)
            }

        }
        list.sort()
        return list.toIntArray()
    }

    private fun createPalindrome(input: Int, b: Int, isOdd:Int):Int{
        var n = input
        var res = input

        if(isOdd == 1){
            n /= b

        }

        while (n > 0) {
            res = res * b + (n % b);
            n /= b;
        }
        return res;
    }
}