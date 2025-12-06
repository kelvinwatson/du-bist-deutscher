package com.watson.kelvin.dubistjetztdeutscher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.ui.theme.DuBistJetztDeutscherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DuBistJetztDeutscherTheme {
                DuBistJetztDeutscherApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun DuBistJetztDeutscherApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            when (currentDestination) {
                AppDestinations.HOME -> HomeDestination(modifier = Modifier.padding(innerPadding))
                AppDestinations.WORSCHATZ -> WorschatzDestination(
                    modifier = Modifier.padding(
                        innerPadding
                    )
                )

                AppDestinations.PROFILE -> ProfileDestination(
                    modifier = Modifier.padding(
                        innerPadding
                    )
                )
            }
        }
    }
}

@Composable
fun HomeDestination(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) { paddingValues ->
        Text(
            text = "Welcome to the Home Screen!",
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Composable
fun WorschatzDestination(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) { paddingValues ->

        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                Text(
                    text = "Welcome to the Wortschatz Screen!",
                    modifier = Modifier.padding(paddingValues),
                )
            }

            item {
                Text(
                    text = "VERBEN",
                    modifier = Modifier.padding(paddingValues),
                )
            }

            item {
                Text(
                    text = "benutzen/verwenden = to use\n",
                    modifier = Modifier.padding(top = 16.dp),
                )
            }

            item {
                Text(
                    text = "mögen (Modalverb) = like (modal). z.B. Ich mag Pizza\n" +
                            "\n" +
                            "möchten (Konjunktiv II—polite form—of mögen, not Modal but used like one) = would like/want (Ich möchte essen)\n" +
                            "wollen (Modalverb) = want (Ich will essen)\n" +
                            "\n" +
                            "werden: to become, will, must be\n" +
                            "* “to become” when used alone\n" +
                            "  - Ich werde Arzt (I become a Dr)\n" +
                            "* “will” when used with infinitive\n" +
                            "  - Ich werde morgen arbeiten (will)\n" +
                            "* “being done” when used with past particip\n" +
                            "  - Das Haus wird gebaut (house is being built)\n" +
                            "* “must be/probably is” when used with present\n" +
                            "  - Er wird krank sein (He must be sick)\n" +
                            "  - Passiv + infinitive: Das Buch würde gelesen werden (The book would be(come) read)\n" +
                            "* würde (Konjunctive II) would (hypothetical / conditional / polite)\n" +
                            "  - Ich würde gehen (I would go)\n",
                    modifier = Modifier.padding(top = 16.dp),
                )
            }
        }

    }
}

@Composable
fun ProfileDestination(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) { paddingValues ->
        Text(
            text = "Welcome to the Profile Screen!", modifier = Modifier.padding(paddingValues),
        )
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Filled.Home),
    WORSCHATZ("Wortschatz", Icons.Filled.Favorite),
    PROFILE("Profile", Icons.Filled.AccountBox),
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DuBistJetztDeutscherTheme {
        Greeting("Android")
    }
}