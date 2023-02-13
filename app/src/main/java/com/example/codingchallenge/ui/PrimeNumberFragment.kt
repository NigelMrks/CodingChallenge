package com.example.codingchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codingchallenge.MainViewModel
import com.example.codingchallenge.databinding.FragmentPrimenumberBinding

class PrimeNumberFragment: Fragment() {
    private lateinit var binding: FragmentPrimenumberBinding
    private val viewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimenumberBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (binding.primeInput.text != null) {
            binding.primeCheckButton.setOnClickListener {
                val input = binding.primeInput.text.toString().toInt()
                if (input <= 0) {
                    binding.primeCheckText.text =
                        "Please input a number greater than 0!"
                }
                else {
                    if (input == 1) {
                        binding.primeCheckText.text =
                            "...It's debatable..."
                    }
                    else {
                        if (viewModel.primeNumber(input)) {
                            binding.primeCheckText.text =
                                "$input IS a prime number."
                        }
                        else {
                            binding.primeCheckText.text =
                                "$input IS NOT a prime number."
                        }
                    }
                }
            }
        }

        binding.primeHomeButton.setOnClickListener {
            findNavController().navigate(PrimeNumberFragmentDirections.actionPrimeNumberFragmentToHomeFragment())
        }

        binding.primeAnagramButton.setOnClickListener {
            findNavController().navigate(PrimeNumberFragmentDirections.actionPrimeNumberFragmentToAnagramFragment())
        }

        binding.primeFibonacciButton.setOnClickListener {
            findNavController().navigate(PrimeNumberFragmentDirections.actionPrimeNumberFragmentToFibonacciFragment())
        }
    }
}