package com.watson.kelvin.dubistjetztdeutscher.data.recent

import kotlinx.coroutines.flow.Flow

interface RecentPagesDataSource {
    val recentPages: Flow<List<String>>

    suspend fun addPage(pageKey: String)
}