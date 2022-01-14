package com.example.cities.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cities.databinding.FragmentHomeBinding
import com.example.cities.domain.model.City
import com.example.cities.presentation.viewmodel.CityState
import com.example.cities.presentation.viewmodel.HomeViewModel
import com.example.cities.presentation.viewmodel.HomeViewModelFactory

import com.example.cities.presentation.viewmodel.CityState.Loading
import com.example.cities.presentation.viewmodel.CityState.Success
import com.example.cities.presentation.viewmodel.CityState.Failure
import kotlinx.coroutines.flow.collect



class HomeFragment : Fragment() {

    var _binding: FragmentHomeBinding?= null
    val binding: FragmentHomeBinding get() = _binding!!


    val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory()
    }

    val citiesAdapter = CitiesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.setFragmentResultListener(ADD_CITY_REQUEST_KEY,viewLifecycleOwner){
            _, bundle -> val city : City? = bundle.getParcelable(CITY_KEY) as? City
            city?.let { homeViewModel.addCity(it) }
        }

        binding.addCityButton.setOnClickListener{
            val addCityFragment = AddCityFragment()
            addCityFragment.show(childFragmentManager, ADD_CITY_TAG)
        }

        binding.citiesRecyclerView.apply {
            adapter = citiesAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            homeViewModel.cityStateFlow.collect { cityState: CityState ->
                setState(cityState)
            }
        }
    }

    private fun setState(cityState: CityState){
        when(cityState){
            Loading -> binding.progressBar.visibility = View.VISIBLE
            is Success -> {
                binding.progressBar.visibility = View.GONE
                val cities = cityState.data
                citiesAdapter.submitList(cities)
            }
            is Failure -> {
                Toast.makeText(context, "Failure!!", Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}