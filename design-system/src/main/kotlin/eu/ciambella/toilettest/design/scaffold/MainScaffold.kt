package eu.ciambella.toilettest.design.scaffold

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import eu.ciambella.toilettest.design.bottombar.AppNavigationBar
import eu.ciambella.toilettest.design.content.IciContent
import eu.ciambella.design.toilettest.scaffold.ScaffoldProperty

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    property: ScaffoldProperty,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ToiletTest"
                    )
                }
            )
        },
        content = {
            IciContent(
                property = property.contentProperty,
                modifier = Modifier.padding(it)
            )
        },
        bottomBar = {
            property.navigationBarProperty?.also {
                AppNavigationBar(bottomBarProperty = it)
            }
        }
    )
}
