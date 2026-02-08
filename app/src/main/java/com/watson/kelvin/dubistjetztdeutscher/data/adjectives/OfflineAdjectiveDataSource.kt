package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.AdjectiveCategory

/**
 * Offline implementation of [AdjectiveRetrieval] that returns all adjectives grouped by category from fallback data.
 *
 * This implementation is stateless and does not cache data.
 */
class OfflineAdjectiveDataSource : AdjectiveRetrieval {
    /**
     * Returns all adjectives grouped by [AdjectiveCategory] using fallback data.
     *
     * @return Map of [AdjectiveCategory] to a map of [GermanAdjective] to [EnglishAdjective].
     */
    override fun getAllAdjectives(): Map<AdjectiveCategory, Map<GermanAdjective, EnglishAdjective>> =
        AdjectiveCategory.entries.associateWith { category -> category.getMap() }
}
