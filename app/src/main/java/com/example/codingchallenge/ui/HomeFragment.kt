package com.example.codingchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codingchallenge.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.homeAnagramButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAnagramFragment())
        }

        binding.homePrimenumbersButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPrimeNumberFragment())
        }

        binding.homeFibonacciButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFibonacciFragment())
        }
    }
}