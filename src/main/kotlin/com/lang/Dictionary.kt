package com.lang

object Dictionary {
    var currentLanguage = SupportedLanguages.RU

    fun getDol() = currentLanguage.dictionaryOfLanguage

}