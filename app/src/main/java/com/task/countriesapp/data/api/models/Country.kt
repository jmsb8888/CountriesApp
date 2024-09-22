package com.task.countriesapp.data.api.models

data class Country(
    val name: Name,
    val tld: List<String>,
    val currencies: Map<String, Currency>,
    val idd: Idd,
    val capital: List<String>,
    val altSpellings: List<String>,
    val region: String,
    val languages: Map<String, String>,
    val latlng: List<Double>,
    val landlocked: Boolean,
    val area: Double,
    val demonyms: Demonyms,
    val flag: String,
    val maps: Maps,
    val population: Int,
    val car: Car,
    val timezones: List<String>,
    val continents: List<String>,
    val flags: Flags,
    val coatOfArms: CoatOfArms?,
    val startOfWeek: String,
    val capitalInfo: CapitalInfo,
    val status : String,
    val translations: Map<String, Translation>
)
