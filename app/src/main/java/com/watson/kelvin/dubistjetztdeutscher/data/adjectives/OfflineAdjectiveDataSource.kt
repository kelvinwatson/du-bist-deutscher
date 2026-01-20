package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory

/**
 * Offline implementation of [AdjectiveRetrieval] that returns all adjectives grouped by category from fallback data.
 *
 * This implementation is stateless and does not cache data.
 */
class OfflineAdjectiveDataSource : AdjectiveRetrieval {
    /**
     * Returns all adjectives grouped by [AdjectiveCategory] using fallback data.
     *
     * @return Map of [AdjectiveCategory] to a map of [EnglishAdjective] to [GermanAdjective].
     */
    override fun getAllAdjectives(): Map<AdjectiveCategory, Map<EnglishAdjective, GermanAdjective>> =
        AdjectiveCategory.entries.associateWith { category ->
            category.getMap()
        }
}
