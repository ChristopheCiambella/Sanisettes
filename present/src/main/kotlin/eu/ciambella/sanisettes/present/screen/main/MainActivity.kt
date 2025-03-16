package eu.ciambella.sanisettes.present.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import eu.ciambella.sanisettes.design.theme.MainTheme
import eu.ciambella.sanisettes.present.screen.list.SANISETTE_LIST_ROUTE
import org.koin.androidx.compose.KoinAndroidContext

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainTheme {
                navHostController = rememberNavController()
                KoinAndroidContext {
                    AppNavHost(
                        navHostController = navHostController,
                        startDestination = SANISETTE_LIST_ROUTE,
                    )
                }
            }
        }
    }
}
