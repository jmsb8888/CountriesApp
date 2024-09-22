package com.task.countriesapp.screens.countries.rv
import androidx.recyclerview.widget.RecyclerView
import com.task.countriesapp.R
import com.task.countriesapp.data.api.models.Country
import com.task.countriesapp.databinding.ActivityCountriesBinding
import com.task.countriesapp.utils.LanguageMapper
import com.task.countriesapp.utils.loadCircleImage

class CountriesViewHolder (
    private val binding: ActivityCountriesBinding,
    private val onViewInfoClickListener: (Name: String) -> Unit,
): RecyclerView.ViewHolder(binding.root) {
    val languageMapper = LanguageMapper()
    fun bind(country: Country) {
        with(binding) {
            btnMoreInfo.setOnClickListener {
                onViewInfoClickListener(country.name.official)
            }

            tvCountryName.text = tvCountryName.context.getString(
                R.string.country_name,
                country.name.official
            )

            val language = languageMapper.getLanguageName(country.languages.keys.first()  ?: "No language")
            tvCountryLanguage.text =
                tvCountryLanguage.context.getString(R.string.country_language, language)

            tvCountryRegion.text =
                tvCountryRegion.context.getString(R.string.country_region, country.region)

            tvCountryCapital.text =
                tvCountryCapital.context.getString(R.string.country_capital, country.capital)

            country.flags?.png?.let { ivCountryFlagPicture.loadCircleImage(it) }

        }
    }
}