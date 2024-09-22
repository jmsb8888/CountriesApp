package com.task.countriesapp.utils

class LanguageMapper {
    private val langMap = mapOf(
        "ara" to "Árabe",
        "bre" to "Bretón",
        "ces" to "Checo",
        "cym" to "Galés",
        "deu" to "Alemán",
        "est" to "Estonio",
        "fin" to "Finés",
        "fra" to "Francés",
        "hrv" to "Croata",
        "hun" to "Húngaro",
        "ita" to "Italiano",
        "jpn" to "Japonés",
        "kor" to "Coreano",
        "nld" to "Neerlandés",
        "per" to "Persa",
        "pol" to "Polaco",
        "por" to "Portugués",
        "rus" to "Ruso",
        "slk" to "Eslovaco",
        "spa" to "Español",
        "srp" to "Serbio",
        "swe" to "Sueco",
        "tur" to "Turco",
        "urd" to "Urdu",
        "zho" to "Chino"
    )

    fun getLanguageName(abbreviation: String): String {
        return langMap[abbreviation] ?: abbreviation
    }
}