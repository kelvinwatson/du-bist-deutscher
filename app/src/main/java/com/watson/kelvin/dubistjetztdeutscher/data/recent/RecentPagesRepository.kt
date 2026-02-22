package com.watson.kelvin.dubistjetztdeutscher.data.recent

import android.content.Context
import androidx.lifecycle.SavedStateHandle

class RecentPagesRepository private constructor(
    private val savedStateHandle: SavedStateHandle,
    private val dataSource: RecentPagesDataSource,
) : RecentPagesDataSource by dataSource {

    companion object Factory {
        private const val RECENT_PAGES_KEY = "recent_pages"

        //TODO - Use Metro for dependency injection instead of this factory method. This is just a
        // temporary solution to avoid adding Metro to the project for now.
        fun create(
            context: Context,
            savedStateHandle: SavedStateHandle,
        ): RecentPagesRepository {
            return RecentPagesRepository(
                savedStateHandle = savedStateHandle,
                dataSource = RecentPagesDataStore(context),
            )
        }
    }
}
