package com.task.countriesapp.screens.country

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.countriesapp.R
import com.task.countriesapp.data.api.models.Translations
import com.task.countriesapp.data.viewmodel.CountryViewModel
import com.task.countriesapp.databinding.ActivityViewCountryBinding
import com.task.countriesapp.screens.country.rv.RvCountryAdapter
import com.task.countriesapp.utils.loadCircleImage
import com.task.countriesapp.utils.loadImage
import kotlinx.coroutines.launch

class ActivityViewCountry : AppCompatActivity() {
    private lateinit var rvCountryAdapter: RvCountryAdapter
    private lateinit var binding: ActivityViewCountryBinding
    private val countryViewModel: CountryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        initUiStateLifecycle()
        getCountryName()
    }
    private fun initRV() {
        rvCountryAdapter = RvCountryAdapter()
        binding.rvLanguages.adapter = rvCountryAdapter
        binding.rvLanguages.layoutManager = LinearLayoutManager(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle() {
        lifecycleScope.launch {
            countryViewModel.uiState.collect { uiState ->
                with(binding) {
                    uiState.country?.let { country ->
                        val translationList: List<Translations> = country.translations.map { (languageCode, translation) ->
                            Translations(languageCode, translation)
                        }
                        tvCountryName.text = tvCountryName.context.getString(
                            R.string.country_name,
                            country.name.official)

                        tvCountryArea.text = tvCountryArea.context.getString(
                             R.string.country_area,
                            country.area.toString()
                        )
                        tvCountryLanguage.text = tvCountryLanguage.context.getString(
                            R.string.country_language,
                            country.languages.values.joinToString(", ")
                        )

                        tvCapital.text = tvCapital.context.getString(
                            R.string.country_capital,
                            country.capital[0]
                        )

                        tvCoordinates.text = tvCoordinates.context.getString(
                            R.string.country_coordinates,
                            country.latlng[0].toString(),
                            country.latlng[1].toString()
                        )
                        country.flags.png.let { ivCountryFlagPicture.loadCircleImage(it) }

                        rvCountryAdapter.countries = translationList
                        rvCountryAdapter.notifyDataSetChanged()
                    }
                    pbCountry.visibility =
                        if (uiState.isCountryLoading) View.VISIBLE else View.INVISIBLE
                }
            }
        }
    }

    private fun getCountryName() {
        val countryName = intent.extras?.getString(COUNTRY_NAME)
        countryName?.let {
            countryViewModel.getCountrybyName(it)
        }
    }

    companion object {
        const val COUNTRY_NAME = "official"
    }
}