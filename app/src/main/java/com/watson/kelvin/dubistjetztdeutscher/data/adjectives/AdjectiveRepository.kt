package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.AdjectiveCategory

/**
 * Repository fun interface for accessing all adjectives grouped by category.
 */
fun interface AdjectiveRepository {
    /**
     * Returns a map of all adjective categories to their German-English adjective pairs.
     */
    fun getAllAdjectives(): Map<AdjectiveCategory, Map<GermanAdjective, EnglishAdjective>>
}
