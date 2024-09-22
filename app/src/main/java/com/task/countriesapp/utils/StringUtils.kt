package com.task.countriesapp.utils

fun String.getIdFromUrl(): Int? =
    this.split("/").lastOrNull()?.toIntOrNull()
