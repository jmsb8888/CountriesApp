package com.task.countriesapp.screens.country.uiState

import com.task.countriesapp.data.api.models.Country

data class CountryUiState(
    val country: Country? = null,
    val isCountryLoading: Boolean = true,
)
