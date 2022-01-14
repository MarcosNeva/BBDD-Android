package com.example.practica01.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.practica01.presentation.viewmodel.HomeViewModel
import com.example.practica01.presentation.viewmodel.HomeViewModelFactory

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory()
    }
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.practiceStateFlow.collect { homeState ->
                setState(homeState)
            }
        }
        viewModel.getData()
    }

    private fun setState(homeState: HomeState) {
        when (homeState) {
            is HomeState.Failure -> {
                binding.loadingProgressBar.isVisible = false
                Toast.makeText(
                    requireContext(), "Failure",
                    Toast.LENGTH_SHORT
                ).show()
            }
            HomeState.Loading -> binding.loadingProgressBar.isVisible = true
            is HomeState.Success -> {
                binding.loadingProgressBar.isVisible = false
                binding.homeTextView.text = homeState.practiceData.name
            }
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}