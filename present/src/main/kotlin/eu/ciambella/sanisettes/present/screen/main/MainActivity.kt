package eu.ciambella.sanisettes.present.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import eu.ciambella.sanisettes.present.screen.list.SANISETTE_LIST_ROUTE

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()
            AppNavHost(
                navHostController = navHostController,
                startDestination = SANISETTE_LIST_ROUTE,
            )
        }
    }
}
