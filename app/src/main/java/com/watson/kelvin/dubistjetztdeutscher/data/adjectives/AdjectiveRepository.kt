package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory

/**
 * Repository fun interface for accessing all adjectives grouped by category.
 */
fun interface AdjectiveRepository {
    /**
     * Returns a map of all adjective categories to their English-German adjective pairs.
     */
    fun getAllAdjectives(): Map<AdjectiveCategory, Map<EnglishAdjective, GermanAdjective>>
}
