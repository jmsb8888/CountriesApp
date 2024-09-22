package com.task.countriesapp.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.countriesapp.data.api.retrofit.RetrofitClient
import com.task.countriesapp.screens.country.uiState.CountryUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountryViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CountryUiState())
    val uiState: StateFlow<CountryUiState> = _uiState.asStateFlow()

    private val retrofitApi by lazy {
        RetrofitClient.getInstance()
    }

    fun getCountrybyName(nameCountry: String) {
        viewModelScope.launch {
            val countryData = retrofitApi.getCountryByName(nameCountry)
            val country = countryData[0]
            val newUiState = _uiState.value.copy(
                country = country,
                isCountryLoading = false
            )
            _uiState.value = newUiState
        }
    }
}