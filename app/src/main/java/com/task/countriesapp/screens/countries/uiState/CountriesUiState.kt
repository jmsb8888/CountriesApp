package com.task.countriesapp.screens.countries.uiState

import com.task.countriesapp.data.api.models.CountriesList

data class CountriesUiState (
    val countries: CountriesList? = null,
    val isLoading: Boolean = true
)