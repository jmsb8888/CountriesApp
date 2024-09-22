package com.task.countriesapp.screens.countries.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.countriesapp.data.api.models.Country
import com.task.countriesapp.databinding.ActivityCountriesBinding

class RVCountriesAdapter (
    private val onViewInfoClickListener: (name: String) -> Unit

): RecyclerView.Adapter<CountriesViewHolder>() {

    var countries = emptyList<Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val binding = ActivityCountriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CountriesViewHolder(
            binding = binding,
            onViewInfoClickListener = onViewInfoClickListener
        )
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

}