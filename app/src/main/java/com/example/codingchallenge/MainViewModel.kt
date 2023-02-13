package com.example.codingchallenge

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    fun anagram(inputA: String, inputB: String): Boolean {
        val copyOfA = inputA.toMutableList()
        var isAnagram = true

        for (char in inputB) {
            if (copyOfA.contains(char)){
                copyOfA.remove(char)
            }
            else isAnagram = false
        }

        if (copyOfA.isNotEmpty()) isAnagram = false

        return isAnagram
    }

    fun primeNumber(input: Int): Boolean {
        var isPrimeNumber = true
        var i = 2
        while (i < input) {
            if (input % i == 0) isPrimeNumber = false
            i++
        }
        return isPrimeNumber
    }

    fun fibonacci(input: Int): Int {
        var fibonacciAtInput: Int = 0
        val fibonacciSequence = mutableListOf<Int>(0, 1)
        when (input) {
            1 -> fibonacciAtInput = 0
            2 -> fibonacciAtInput = 1
            else -> {
                var i = 2
                while (i <= input) {
                    fibonacciAtInput =
                        fibonacciSequence[fibonacciSequence.size-1] +
                                fibonacciSequence[fibonacciSequence.size-2]
                    fibonacciSequence.add(fibonacciAtInput)
                    i++
                }
            }
        }
        return fibonacciAtInput
    }
}