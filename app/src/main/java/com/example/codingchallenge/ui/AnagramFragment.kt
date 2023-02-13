package com.example.codingchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codingchallenge.MainViewModel
import com.example.codingchallenge.databinding.FragmentAnagramBinding

class AnagramFragment: Fragment() {

    private lateinit var binding: FragmentAnagramBinding
    private val viewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnagramBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (binding.anagramInputA.text != null && binding.anagramInputB.text != null) {
            binding.anagramCheckButton.setOnClickListener {
                var inputA = binding.anagramInputA.text.toString()
                var inputB = binding.anagramInputB.text.toString()
                if (viewModel.anagram(inputA, inputB)) {
                    binding.anagramCheckText.text =
                        "$inputB IS an anagram of $inputA."
                }
                else {
                    binding.anagramCheckText.text =
                        "$inputB IS NOT an anagram of $inputA."
                }
            }
        }

        binding.anagramHomeButton.setOnClickListener {
            findNavController().navigate(AnagramFragmentDirections.actionAnagramFragmentToHomeFragment())
        }

        binding.anagramPrimeButton.setOnClickListener {
            findNavController().navigate(AnagramFragmentDirections.actionAnagramFragmentToPrimeNumberFragment())
        }

        binding.anagramFibonacciButton.setOnClickListener {
            findNavController().navigate(AnagramFragmentDirections.actionAnagramFragmentToFibonacciFragment())
        }
    }
}