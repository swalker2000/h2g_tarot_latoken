package com.lang


import com.lang.ru.DictionaryOfRussian

enum class SupportedLanguages(val dictionaryOfLanguage: DictionaryOfLanguage) {
    RU(DictionaryOfRussian())
}