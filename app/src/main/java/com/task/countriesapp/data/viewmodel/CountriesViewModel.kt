package com.task.countriesapp.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.countriesapp.data.api.models.CountriesList
import com.task.countriesapp.data.api.retrofit.RetrofitClient
import com.task.countriesapp.screens.countries.uiState.CountriesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountriesViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CountriesUiState())
    val uiState: StateFlow<CountriesUiState> = _uiState.asStateFlow()

    private val retrofitApi by lazy {
        RetrofitClient.getInstance()
    }

    init {
        viewModelScope.launch {
            getCountries()
        }
    }

    private suspend fun getCountries() {
        val countriesData = retrofitApi.getCountries()
        val countries = CountriesList(countriesData)
        _uiState.value = _uiState.value.copy(
            isLoading = false,
            countries = countries
        )
    }
}