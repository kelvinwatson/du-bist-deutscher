package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.AdjectiveCategory

/**
 * Default implementation of [AdjectiveRepository] that provides caching for adjective data.
 *
 * This repository is responsible for providing access to adjective data, and can be easily swapped for other data sources (e.g., network, database).
 *
 * @property dataSource The data source used to retrieve adjective data. Defaults to [OfflineAdjectiveDataSource].
 */
class DefaultAdjectiveRepository(
    /**
     * The data source used for retrieving adjective data. Can be replaced for testing or different data sources.
     */
    private val dataSource: AdjectiveRetrieval = OfflineAdjectiveDataSource(),
) : AdjectiveRepository {
    /**
     * Cached adjectives, built on first access and reused for all subsequent calls.
     */
    private var cachedAdjectives: Map<AdjectiveCategory, Map<GermanAdjective, EnglishAdjective>>? = null

    override fun getAllAdjectives(): Map<AdjectiveCategory, Map<GermanAdjective, EnglishAdjective>> {
        return cachedAdjectives ?: dataSource.getAllAdjectives().also { cachedAdjectives = it }
    }
}
