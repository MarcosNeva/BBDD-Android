package com.example.cities.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.cities.databinding.CityItemBinding
import com.example.cities.databinding.FragmentHomeBinding
import com.example.cities.domain.model.City
import com.example.cities.presentation.view.CitiesAdapter.CityViewHolder
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent


class CitiesAdapter: androidx.recyclerview.widget.ListAdapter <City,CityViewHolder> (CitiesDiffUtilCallback) {

    inner class CityViewHolder(val binding: CityItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = CityItemBinding.inflate(LayoutInflater.from(parent.context),
           parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.binding.cityName.text = city.name
        holder.binding.cityDescription.text = city.description
    }


}

object CitiesDiffUtilCallback: DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.id == newItem.id
    }
}