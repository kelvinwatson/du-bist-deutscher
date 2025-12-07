package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys

import androidx.annotation.StringRes
import androidx.navigation3.runtime.NavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.AppStringResource

/**
 * Base for all app navigation keys. Holds a unique identifier and title resource for each key.
 *
 * These represent top level navigation destinations in the app. Each of these keys will correspond
 * to a distinct screen or feature set within the application. Specifically, each [AppNavKey] will
 * correspond to a top level destination. A typical stack could look like this:
 *
 * ```
 *    - Prepositions     <-- navigating back from this point will pop Prepositions off the stack
 *  EmbeddedNavDisplay   <-- user navigates to Prepositions screen from Grammar screen
 *    - Grammar          <-- user navigates to Grammar screen via bottom bar
 *    - Overview         <-- user starts in the Overview screen
 *  BottomNavDisplay
 *   ```
 */
interface AppNavKey : NavKey, NavIdentifier

interface NavIdentifier {
    /**
     * A unique identifier for this navigation key.
     */
    val id: String

    /**
     * A factory that produces the title for this navigation key.
     */
    @get:StringRes
    val titleRes: Int
}