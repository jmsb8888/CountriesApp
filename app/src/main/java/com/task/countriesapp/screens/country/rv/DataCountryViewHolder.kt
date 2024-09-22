package com.task.countriesapp.screens.country.rv

import androidx.recyclerview.widget.RecyclerView
import com.task.countriesapp.R
import com.task.countriesapp.data.api.models.Country
import com.task.countriesapp.data.api.models.Translation
import com.task.countriesapp.data.api.models.Translations
import com.task.countriesapp.databinding.ActivityNameTranslationsViewBinding
import com.task.countriesapp.databinding.ActivityViewCountryBinding
import com.task.countriesapp.utils.LanguageMapper
import com.task.countriesapp.utils.loadImage

class DataCountryViewHolder(
    private val binding: ActivityNameTranslationsViewBinding
): RecyclerView.ViewHolder(binding.root) {
    private val languageMapper = LanguageMapper()
    fun bind(translationCurrent: Translations) {
        with(binding) {
            val translatedLanguages = languageMapper.getLanguageName(translationCurrent.languageCode)

            tvCommonTranslation.text =  tvCommonTranslation.context.getString(
                R.string.language_name_common,
                translationCurrent.translation.common
            )

            tvOfficialTranslation.text = tvOfficialTranslation.context.getString(
                R.string.language_name_official,
                translationCurrent.translation.official
            )
            tvLanguage.text = translatedLanguages
        }
    }
}