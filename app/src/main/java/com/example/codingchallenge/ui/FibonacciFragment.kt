package com.example.codingchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codingchallenge.MainViewModel
import com.example.codingchallenge.databinding.FragmentFibonacciBinding

class FibonacciFragment: Fragment() {

    private lateinit var binding: FragmentFibonacciBinding
    private val viewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFibonacciBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (binding.fibonacciInput.text != null) {
            binding.fibonacciCheckButton.setOnClickListener {
                val input = binding.fibonacciInput.text.toString().toInt()
                if (input <= 0) {
                    binding.fibonacciCheckText.text =
                        "Please input a number greater than 0!"
                }
                else {
                    var fibonacciAtInput = viewModel.fibonacci(input)
                    binding.fibonacciCheckText.text =
                        "The #$input in the Fibonacci-Sequence is: \n \n $fibonacciAtInput"
                }
            }
        }

        binding.fibonacciHomeButton.setOnClickListener {
            findNavController().navigate(FibonacciFragmentDirections.actionFibonacciFragmentToHomeFragment())
        }

        binding.fibonacciAnagramButton.setOnClickListener {
            findNavController().navigate(FibonacciFragmentDirections.actionFibonacciFragmentToAnagramFragment())
        }

        binding.fibonacciPrimeButton.setOnClickListener {
            findNavController().navigate(FibonacciFragmentDirections.actionFibonacciFragmentToPrimeNumberFragment())
        }
    }
}