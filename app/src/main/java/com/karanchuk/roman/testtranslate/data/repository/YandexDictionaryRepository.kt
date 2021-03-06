package com.karanchuk.roman.testtranslate.data.repository

import com.karanchuk.roman.testtranslate.data.database.model.DictDefinition
import com.karanchuk.roman.testtranslate.data.network.YandexDictionaryApi
import io.reactivex.Single


interface YandexDictionaryRepository {

    fun getValueFromDictionary(
        key: String,
        text: String,
        lang: String
    ): Single<DictDefinition>

    suspend fun getValueFromDictionaryCoroutine(
        key: String,
        text: String,
        lang: String
    ): DictDefinition
}

class YandexDictionaryRepositoryImpl(
    private val api: YandexDictionaryApi
) : YandexDictionaryRepository {

    override fun getValueFromDictionary(
        key: String,
        text: String,
        lang: String
    ): Single<DictDefinition> {
        return api.getValueFromDictionary(key, text, lang)
    }

    override suspend fun getValueFromDictionaryCoroutine(
        key: String,
        text: String,
        lang: String
    ): DictDefinition {
        return api.getValueFromDictionaryCoroutine(key, text, lang)
    }
}