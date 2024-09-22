package com.task.countriesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.countriesapp.data.viewmodel.CountriesViewModel
import com.task.countriesapp.databinding.ActivityMainBinding
import com.task.countriesapp.screens.countries.rv.RVCountriesAdapter
import com.task.countriesapp.screens.country.ActivityViewCountry
import com.task.countriesapp.screens.country.ActivityViewCountry.Companion.COUNTRY_NAME
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val countriesViewModel: CountriesViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCountriesAdapter: RVCountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        initUiStateLifecycle()
    }

    private fun initRV() {
        rvCountriesAdapter = RVCountriesAdapter(
            onViewInfoClickListener = { countryName ->
                launchCountryActivity(countryName)
            }
        )
        binding.rvCountries.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvCountriesAdapter
        }
    }

    private fun launchCountryActivity(countryName: String) {
        startActivity(Intent(this, ActivityViewCountry::class.java).apply{
            putExtras(bundleOf(COUNTRY_NAME to countryName))
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle() {
        lifecycleScope.launch {
            countriesViewModel.uiState.collect { uiState ->
                uiState.countries?.countries?.let { countriesList ->
                    rvCountriesAdapter.countries = countriesList
                    rvCountriesAdapter.notifyDataSetChanged()
                }
                binding.rvCountries.visibility = if (uiState.isLoading) View.INVISIBLE else View.VISIBLE
                binding.pbCountries.visibility = if (uiState.isLoading.not()) View.INVISIBLE else View.VISIBLE
            }
        }
    }
}