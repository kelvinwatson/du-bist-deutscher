package com.watson.kelvin.dubistjetztdeutscher.data.adjectives

/**
 * Default implementation of [AdjectiveRepository] that delegates all operations to the provided [AdjectiveRetrieval] data source.
 *
 * This repository is responsible for providing access to adjective data, and can be easily swapped for other data sources (e.g., network, database).
 *
 * @property dataSource The data source used to retrieve adjective data. Defaults to [OfflineAdjectiveDataSource].
 */
class DefaultAdjectiveRepository(
    /**
     * The data source used for retrieving adjective data. Can be replaced for testing or different data sources.
     */
    private val dataSource: AdjectiveRetrieval = OfflineAdjectiveDataSource()
) : AdjectiveRepository, AdjectiveRetrieval by dataSource

