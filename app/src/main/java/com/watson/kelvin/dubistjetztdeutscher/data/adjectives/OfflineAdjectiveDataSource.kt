package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory

/**
 * Offline implementation of [AdjectiveRetrieval] that returns all adjectives grouped by category from fallback data.
 */
class OfflineAdjectiveDataSource : AdjectiveRetrieval {
    override fun getAllAdjectives(): Map<AdjectiveCategory, Map<String, String>> =
        AdjectiveCategory.entries.associateWith { it.getMap() }
}
