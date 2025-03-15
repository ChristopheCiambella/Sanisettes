package eu.ciambella.toilettest.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import eu.ciambella.design.scaffold.MainScaffold
import eu.ciambella.toilettest.navigation.AppNavHost
import eu.ciambella.toilettest.present.screen.list.TOILET_LIST_ROUTE
import eu.ciambella.toilettest.ui.theme.MyApplicationTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()
            AppNavHost(
                navHostController = navHostController,
                startDestination = TOILET_LIST_ROUTE,
            )
        }
    }
}
