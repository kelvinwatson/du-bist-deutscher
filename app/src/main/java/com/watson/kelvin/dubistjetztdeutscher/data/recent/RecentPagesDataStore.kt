package com.watson.kelvin.dubistjetztdeutscher.data.recent

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


/**
 * A simple DataStore implementation to manage the list of recently accessed pages. It stores the
 * page keys as a comma-separated string in the preferences. The `recentPages` flow emits the
 * current list of recent pages whenever it changes, and the `addPage` function updates the list by
 * adding a new page key while ensuring that duplicates are avoided and only the most recent 3 pages
 * are kept. While this implementation is straightforward, it may not be the most efficient for
 * larger lists of recent pages, but it is sufficient for the current requirement of keeping track
 * of only the 3 most recent pages. A collection is obviously more efficient for larger lists, but
 * it would add unnecessary complexity for this use case.
 */
class RecentPagesDataStore(private val context: Context) : RecentPagesDataSource {
    override val recentPages: Flow<List<String>>
        get() = context.dataStore.data.map { prefs ->
            prefs[RECENT_PAGES]?.split(",")?.filter { it.isNotBlank() }
                ?: emptyList()
        }

    override suspend fun addPage(pageKey: String) {
        context.dataStore.edit { prefs ->
            val current = prefs[RECENT_PAGES]?.split(",")?.filter { it.isNotBlank() }
                ?: emptyList()
            val updated = listOf(pageKey) + current.filter { it != pageKey }
            prefs[RECENT_PAGES] = updated.take(3).joinToString(",")
        }
    }

    companion object RecentPagesKeys {
        private const val DATASTORE_NAME = "recent_pages_datastore"

        private val RECENT_PAGES = stringPreferencesKey("recent_pages")

        private val Context.dataStore by preferencesDataStore(DATASTORE_NAME)
    }
}
