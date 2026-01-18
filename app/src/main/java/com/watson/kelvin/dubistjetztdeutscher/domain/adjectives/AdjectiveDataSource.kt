package com.watson.kelvin.dubistjetztdeutscher.domain.adjectives

import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectivesFallbackData

interface AdjectiveDataSource {
    fun getAllCategories(): List<AdjectiveCategory>
    fun getAdjectivesForCategory(category: AdjectiveCategory): Map<String, String>
}

class OfflineAdjectiveDataSource : AdjectiveDataSource {
    override fun getAllCategories(): List<AdjectiveCategory> = AdjectiveCategory.entries
    override fun getAdjectivesForCategory(category: AdjectiveCategory): Map<String, String> = category.getMap()
}

