package com.task.countriesapp.screens.country.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.countriesapp.data.api.models.Country
import com.task.countriesapp.data.api.models.Translation
import com.task.countriesapp.data.api.models.Translations
import com.task.countriesapp.databinding.ActivityNameTranslationsViewBinding
import com.task.countriesapp.databinding.ActivityViewCountryBinding

class RvCountryAdapter : RecyclerView.Adapter<DataCountryViewHolder>() {
    var countries = emptyList<Translations>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataCountryViewHolder {
        val binding = ActivityNameTranslationsViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DataCountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataCountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size
}