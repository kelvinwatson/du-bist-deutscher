package com.watson.kelvin.dubistjetztdeutscher.domain.adjectives

import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory
import com.watson.kelvin.dubistjetztdeutscher.data.adjectives.AdjectiveRepository
import com.watson.kelvin.dubistjetztdeutscher.data.adjectives.DefaultAdjectiveRepository

// Use case interface for searching adjectives
interface AdjectiveSearchUseCase {
    fun searchAdjectives(query: String): List<Pair<AdjectiveCategory, List<Pair<String, String>>>>
}

class DefaultAdjectiveSearchUseCase(
    private val repository: AdjectiveRepository = DefaultAdjectiveRepository()
) : AdjectiveSearchUseCase {
    override fun searchAdjectives(query: String): List<Pair<AdjectiveCategory, List<Pair<String, String>>>> {
        val trimmed = query.trim().lowercase()
        return repository.getAllAdjectives().mapNotNull { (category, adjectives) ->
            val matches = if (trimmed.isEmpty()) {
                adjectives.entries.toList()
            } else {
                adjectives.entries.filter { entry ->
                    entry.key.contains(trimmed, ignoreCase = true) ||
                    entry.value.contains(trimmed, ignoreCase = true)
                }
            }
            if (matches.isNotEmpty()) category to matches.map { it.key to it.value } else null
        }
    }
}

// TODO: Use a dependency injection framework (e.g., Koin) for providing use case, repository, and data source in the future.
