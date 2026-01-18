package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory

/**
 * Interface for retrieving all adjectives and their categories from any data source (offline, network, etc).
 *
 * Implementations should provide access to a map of categories to their adjective mappings.
 */
interface AdjectiveRetrieval {
    /**
     * Returns a map of all adjective categories to their English-German adjective pairs.
     *
     * @return A map where the key is the category and the value is a map of English to German adjectives.
     */
    fun getAllAdjectives(): Map<AdjectiveCategory, Map<String, String>>
}
