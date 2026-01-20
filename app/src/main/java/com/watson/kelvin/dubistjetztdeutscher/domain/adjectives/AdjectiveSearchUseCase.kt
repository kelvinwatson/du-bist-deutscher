package com.watson.kelvin.dubistjetztdeutscher.domain.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.adjectives.AdjectiveRepository
import com.watson.kelvin.dubistjetztdeutscher.data.adjectives.DefaultAdjectiveRepository
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory

// Use case interface for searching adjectives
interface AdjectiveSearchUseCase {
    fun searchAdjectives(query: String): List<Pair<AdjectiveCategory, List<Pair<EnglishAdjective, GermanAdjective>>>>
}

class DefaultAdjectiveSearchUseCase(
    private val repository: AdjectiveRepository = DefaultAdjectiveRepository()
) : AdjectiveSearchUseCase {
    override fun searchAdjectives(query: String): List<Pair<AdjectiveCategory, List<Pair<EnglishAdjective, GermanAdjective>>>> {
        val trimmedQuery = query.trim().lowercase()
        return repository.getAllAdjectives()
            .mapNotNull { (category: AdjectiveCategory, adjectivesMap: Map<EnglishAdjective, GermanAdjective>) ->
                val matches: List<Map.Entry<EnglishAdjective, GermanAdjective>> =
                    if (trimmedQuery.isEmpty()) {
                        adjectivesMap.entries.toList()
                    } else {
                        adjectivesMap.entries.filter { entry ->
                            entry.key.contains(trimmedQuery, ignoreCase = true) ||
                                    entry.value.contains(trimmedQuery, ignoreCase = true)
                        }
                    }
                matches.takeIf { it.isNotEmpty() }?.let {
                    category to matches.map { it.key to it.value }
                }
            }
    }
}

// TODO: Use a dependency injection framework (e.g., Koin) for providing use case, repository, and data source in the future.
