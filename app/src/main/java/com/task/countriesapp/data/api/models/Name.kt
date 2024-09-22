package com.task.countriesapp.data.api.models

data class Name(
    val common: String,
    val official: String,
    val nativeName: Map<String, NativeName>
)
