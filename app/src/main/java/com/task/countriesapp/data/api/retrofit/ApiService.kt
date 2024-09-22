package com.task.countriesapp.data.api.retrofit

import com.task.countriesapp.data.api.models.Country
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("all")
    suspend fun getCountries(): List<Country>

    @GET("name/{nameCountry}")
    suspend fun getCountryByName(@Path("nameCountry") id: String): List<Country>
}