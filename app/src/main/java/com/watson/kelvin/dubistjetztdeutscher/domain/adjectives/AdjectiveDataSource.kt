package com.watson.kelvin.dubistjetztdeutscher.domain.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.AdjectiveCategory

interface AdjectiveDataSource {
    fun getAllCategories(): List<AdjectiveCategory>
    fun getAdjectivesForCategory(category: AdjectiveCategory): Map<GermanAdjective, EnglishAdjective>
}

class DefaultAdjectiveDataSource : AdjectiveDataSource {
    override fun getAllCategories(): List<AdjectiveCategory> = AdjectiveCategory.entries
    override fun getAdjectivesForCategory(category: AdjectiveCategory): Map<GermanAdjective, EnglishAdjective> =
        category.getMap()
}
